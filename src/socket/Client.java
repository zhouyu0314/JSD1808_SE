package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



/**
 * 聊天室客户端
 * @author zy
 *
 */

public class Client {
	/**
	 * java.net.Socket
	 * 封装TCP通讯协议的细节操作。java中想完成TCP协议通讯
	 * 就依靠这个API即可。使用它与服务端链接后，通过操作两个流
	 * 即可完成与服务端的数据交换。
	 */
	private Socket socket;
	/**
	 * 构造方法，用初始化客户端
	 */
	public Client(){
		try {
			/*
			 * 实例化Socket时传入两个参数
			 * 1：服务端的IP地址信息
			 * 2：服务端的服务端口号
			 * 
			 * 通过IP地址可以找到服务端的计算机，
			 * 通过端口号可以找到运行在服务端计算机上的服务端应用程序。
			 * 
			 * 实例化的过程就是连接的过程，若连接失败会抛出异常。
			 */
			System.out.println("正在连接服务端。。。");
			socket = new Socket("localhost",8088);
			System.out.println("已连接！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 客户端开始工作的方法
	 * @param args
	 */
	Scanner scan = new Scanner(System.in);

	public void start(){
		try {
			//先启动用于读取服务端消息的线程
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			/*
			 * Socket提供的方法：
			 * OutputStream getOutputStream()
			 * 该方法可以获取一条字节输出流，通过这个流写出的数据会被发送
			 * 给远端（这里相当于发送给了服务端）
			 */
			OutputStream out = socket.getOutputStream();//返回了一个低级流作为入口
			OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw,true);
			System.out.println("请输入：");

			
			while(true){
				String str = scan.nextLine();
				pw.println(str);
				

			}

			//FileOutputStream fos = new FileOutputStream("fos.txt");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
	private class ServerHandler implements Runnable{
		public void run(){
			//读取服务端发送过来的一行字符串
			try {
				//通过Socket获取输入流读取服务端发送过来的消息
				InputStream	in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"utf-8");
				BufferedReader br = new BufferedReader(isr);
				String message = null;
				//循环读取服务端发送过来的每行字符串
				while((message=br.readLine())!=null){
					System.out.println(message);
				}

			} catch (IOException e) {

			}

		}
	}

}

