package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流
 * 注：java.io.BufferedWriter是缓冲字符输出流，PW总是会
 * 在内部链接他来完成缓冲工作，而PW在其基础上还支持自动的行刷新操作，
 * 所以更为常用。
 * 
 * 缓冲字符输出流除了写出字符效率高之外，
 * 还可以按行写出字符串（写出个字符串后会自动添加换行符）
 * @author zy
 *
 */

public class PrintWriterDemo1 {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		/*
		 * PW提供了直接写文件的构造方法
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 * 
		 * 也支持重载构造方法，第二个参数为字符集，这样就可以按照
		 * 指定的字符集将字符写入文件。
		 */
		//向pw.txt文件中写字符串
		PrintWriter pw = new PrintWriter("pw.txt","utf-8");
		pw.println("让我掉下眼泪的，不止昨夜的酒。");
		pw.println("让我依依不舍的，不止你的温柔。");
		pw.close();
		

	}

}
