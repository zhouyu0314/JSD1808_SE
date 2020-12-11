package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 聊天室服务端
 * @author zy
 *
 */

public class Server {
	/*
	 * 运行在服务端的java.net.ServerSocket
	 * 主要有两个作用：
	 * 1：向系统申请服务端口，客户端就是通过该端口与服务端
	 * 建立连接的。
	 * 2：监听服务端口，一旦客户端发起连接则会自动创建
	 * 一个Socket与该客户端进行交互。
	 */
	private ServerSocket server;
	/*
	 * 该数据用于保存所有ClientHandler对应的输出流
	 * 便于所有ClientHandler获取以广播消息给所有的
	 * 客户端
	 * 由于内部类可以访问外部类的属性，对此经常可以在外部类
	 * 上定义属性作为所有内部类的公共区域来共享他们的信息使用。
	 */
	private PrintWriter[] allOut = {};
	//private int index = 0;

	/*
	 * 服务端初始化
	 */
	public Server(){
		try {
			/*
			 * 实例化ServerSocket的同时向系统申请服务端口
			 * 若端口已经被其他应用程序占用时会抛出地址被使用的异常。
			 */
			System.out.println("正在启动服务端。。。");
			server = new ServerSocket(8088);
			System.out.println("服务端启动完毕！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * 服务端开始工作的方法
	 */
	public void start(){
			

		try{
			

			/*
			 * Socket accept()
			 * 该方法是一个阻塞方法，当调用后就开始等待客户端的连接，
			 * 直到一个客户端连接，那么该方法会返回一个Socket，
			 * 服务端可以通过这个Socket与刚建立连接的客户端进行交互。
			 */
			while(true){
				System.out.println("主线程：等待客户端连接");
				Socket socket = server.accept();
				System.out.println("主线程：一个客户端连接了。");
				//allOut = Arrays.copyOf(allOut, allOut.length+1);
				//index++;
				//启动一个线程来处理该客户端交互
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);

				t.start();



			}

		}catch(Exception e){
		e.printStackTrace();
		System.out.println("客户端已断开！");
	}
		

	}
	

	public static void main(String[] args) {
		Server server = new Server();
			server.start();


	}
	/**
	 * 该线程的任务为与指定客户端进行交互
	 * @author zy
	 *
	 */
	private class ClientHandler implements Runnable{
		private Socket socket;
		private String host;
		public ClientHandler(Socket socket){
			this.socket = socket;
			//通过socket获取远端计算机地址信息
			InetAddress address = socket.getInetAddress();
			//获取远端计算机IP地址的字符串形式
			host = address.getHostAddress();
		}
		public void run(){
			PrintWriter pw = null ;
			try{
				/*
				 * 通过Socket获取输出流，用于给客户端发送消息
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
				BufferedWriter bw = new BufferedWriter(osw);
				pw = new PrintWriter(bw,true);
				
				/*
				 * 多个ClientHandler不能同时向数组添加元素否则会出现并发安全问题。
				 * 对此下面代码要保证同步运行。
				 */
				synchronized(allOut){
					/*
					 * 将该输入流存入allOut数组中，以便其他ClientHandler
					 * 也可以将消息转发给当前客户端
					 */
					//1扩容数据
					allOut = Arrays.copyOf(allOut, allOut.length+1);
					//2将当前输出流存入数据
					allOut[allOut.length-1] = pw;
				}

				
				/*
				 * 通过Socket获取输入流：
				 * InputStream getInputStream()
				 * 通过这个流就可以读取到客户端发送过来的消息
				 * 
				 */


			InputStream in = socket.getInputStream();
			//System.out.println("低级流");
			InputStreamReader isr = new InputStreamReader(in,"utf-8");
			//System.out.println("转换流");
			BufferedReader br = new BufferedReader(isr);
			//回复客户端
			//System.out.println("字符缓冲流");

			/*
			 * 服务端通过br.readLine方法读取客户端发送过来的一行字符串时，当客户端断开连接时，
			 * 客户端在不同的操作系统上，服务端这边的反应是不同的：
			 * 当windows的客户端断开连接时，服务端这边通常readLine方法会直接抛出异常。
			 * 当linux的客户端断开连接时，服务端这边的常见反应时readLine方法返回null。
			 */
			String line = null;
			while((line = br.readLine())!=null){
				//System.out.println("line不等于null");
				
				System.out.println(host+"："+line);
				//pw.println(host+"："+line);
				//allOut = Arrays.copyOf(allOut, allOut.length+1);
				//allOut[index-1] = pw;
				//遍历allOut数组，给所有客户端发送
				synchronized(allOut){
					for(int i=0;i<allOut.length;i++){
						allOut[i].println(host+"："+line);
					}
				}
		}
			System.out.println("客户端还没有说话");

			}catch(Exception e){
				
			}finally{
				//处理当前客户端断开连接后的操作
				try {
					synchronized(allOut){
						for(int i=0;i<allOut.length;i++){
							if(allOut[i]==pw){
								//将其与最后一个元素交换
								allOut[i] = allOut[allOut.length-1];
								break;
							}
						}
						//缩容
						allOut = Arrays.copyOf(allOut, allOut.length-1);
					}
					//关闭socket释放资源
					socket.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			
		}
	}

}






















