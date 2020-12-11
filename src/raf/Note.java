package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 简易记事本工具
 * 程序启动后，要求用户输入一个文件名，然后对该文件进行写操作。
 * 之后用户输入的每行字符串都顺序写入到该文件中，当用户单独输入"exit"时，程序退出。
 * @author Administrator
 *
 */

public class Note {

	public static void main(String[] args) throws IOException {
		System.out.println("程序启动，请输入文件名：");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.next();
		RandomAccessFile raf = new RandomAccessFile(fileName,"rw");


		while(true){
			System.out.println("请输入内容：");
			fileName = scan.next();
			if(fileName.equals("exit")){
				break;
			}
			byte[] b = fileName.getBytes("utf-8");
			raf.write(b);
		}
		System.out.print("写入完毕！");
		raf.close();


		
		

	}

}
