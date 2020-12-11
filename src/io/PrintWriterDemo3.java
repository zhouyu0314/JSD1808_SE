package io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 完成建议记事本工具
 * 输入文件名，对文件写操作，之后输入的每行字符串都按行写入到文件中，
 * 当输入exit时程序退出。
 * 
 * 注：创建PrintWriter使用流链接。
 * @author zy
 *
 */

public class PrintWriterDemo3 {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入文件名：");
		FileOutputStream fos = new FileOutputStream(scan.nextLine());
		OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
		BufferedWriter bw = new BufferedWriter(osw);
		/*
		 * 在流链接中创建PrintWriter时，支持第二个参数（直接链接文件不支持）
		 * 该参数为boolean型，若为true，则表示创建的PrintWriter
		 * 为自动行刷新模式。即：每当调用println方法写出一行字符串后就会
		 * 自动进行flush操作。
		 * 注：调用print方法时不会flush的。
		 */
		PrintWriter pw = new PrintWriter(bw,true);
		System.out.println("请输入内容：");
		while(true){
			String str = scan.nextLine();

			if(str.equals("exit")){
				break;
			}
			pw.println(str);
		}
		System.out.println("输入完毕！");
		pw.close();
		

		

	}

}
