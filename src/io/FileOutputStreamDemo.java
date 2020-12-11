package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO java标准的输入与输出
 * IO可以让我们的java程序以标准的读写方式与外界交换数据
 * 
 * 根据读写的功能划分方向；
 * 输入：用来读取数据。（从外界进入我们程序的方向）
 * 输出：用来写出数据。（从程序向外发送数据的方向）
 * 
 * java.io.InputStream
 * 所有字节输入流的超流，本身是一个抽象类，并不能
 * 直接实例化，它规定了所有字节输入流都必须具有的读取字节数据的相关方法。
 * 
 * java.io.OutputStream
 * 所有字节输出流的父类，是抽象类，规定了所有字节输出流必须具备的写出字节方法。
 * 
 * java将流分为两大类：节点流和处理流
 * 
 * 节点流也称为低级流，特点是：真实链接程序与数据源的"管道"
 * 负责实际读写数据的流。读写一定是建立在低级流基础上进行的。
 * 
 * 处理流也称为高级流，其不能独立存在，必须链接在其他流上，这样当数据"流经"
 * 当前高级流时可以对该数据做某些加工处理，
 * 简化我们对该数据的读写操作。
 * 
 * 
 * 
 * 
 * 
 * 文件流
 * java.io.FileInputStream与FileOutputStream
 * 文件流是一对低级流，是用来读写文件数据的流。
 * 
 * 它们与RandomAccessFile都是用来读写文件数据的，但是
 * 底层实际的读写方式不同。
 * [流是顺序读写的]，所以使用文件流读写文件数据是不能"回头"的。对此，
 * 文件流不具备对文件内容的编辑操作。
 * 读写的灵活性而言没有RandomAccessFile强，但是基于流的特点，
 * 利用高级流可以轻松对复杂数据进行读写。
 * RandomAccessFile利用指针读写，所以可以对文件任意位置进行
 * 读写操作，从而可以进行编辑操作。
 * @author zy
 *
 */

public class FileOutputStreamDemo {
	/*
	 * 向文件中写入数据
	 * 
	 * 文件流创建时，有两种写模式：
	 * 1、覆盖写模式，即如果该文件已经存在，则会先将文件数据清除。然后
	 * 通过该流写入的数据作为文件数据；
	 * 2、追加写模式，在构造方法中再传入一个boolean值参数，
	 * 若该值为true，则是追加模式。那么若文件存在，则原数据保留，
	 * 通过该流写入的数据会被追加到文件末尾。
	 */

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("fos.txt");
		//和RandomAccessFile一样可以跟路径也可以直接跟file
		fos.write("听我说，啊啊啊啊，啊啊啊啊。".getBytes("GBK"));
		System.out.println("写入完毕！");
		FileInputStream fis = new FileInputStream("fos.txt");
		byte[] data = new byte[100];
		int len = fis.read(data);
		System.out.println("len:"+len);
		System.out.println(new String(data,0,len,"GBK"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
