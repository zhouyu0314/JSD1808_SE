package io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 在流链接中使用PrintWriter
 * @author zy
 *
 */

public class PrintWriterDemo2 {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		FileOutputStream fos = new FileOutputStream("pw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw = new PrintWriter(bw);
		pw.println("asdfg");
		System.out.println("输出完毕！");
		pw.close();
		
		

	}

}
