package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * 专门用来读写文件数据的API，RAF基于指针对文件数据读写。
 * 可以移动指针读写任意位置，所以可以灵活的对文件数据进行
 * 编辑工作。
 * 创建RAF时有两种常见模式：
 * r：只读模式
 * rw：读写模式
 * @author zy
 *
 */

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * 向当前目录中的文件aaa.dat中写入一个字节
		 * 创建RandomAccessFile时常用的构造方法：
		 * RandomAccessFile(String path,String mode)
		 * RandomAccessFile(File file,String mode)
		 * 
		 * mode:模式，可以用"rw","r"
		 * 注意，若是只读模式时，文件不存在时会抛出异常，若读写模式，则会在不存在时自动创建该文件
		 */
		RandomAccessFile raf = new RandomAccessFile("aaa.dat","rw");
		
		/*
		 * void write(int d)
		 * 向文件中写入1个字节，写入的时给定的int值所对应的2进制的"低8位"
		 */
		raf.write(97);//写入第一个8位
		raf.write(64);//写入第二个8位
		System.out.println("写出完毕！");
		raf.close();
		
		

	}

}
