package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 缓冲字符输出流
 * java.io.BufferedReader
 * 特点：可以按行读取字符串
 * @author zy
 *
 */

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * 将当前源代码读取出来并输入到控制台
		 */
		FileInputStream fis = new FileInputStream("src/io/BufferedReaderDemo.java");
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		/*
		 * BR提供的方法：
		 * String readLine()
		 * 连续读取若干字符，直到读取了换行符为止（\n），然后读取的字符以字符串形式返回。
		 * 注意，返回的字符串中不含有最后的换行符。
		 * 当返回值为null时，表示流读取到末尾。
		 */
		
		String line = null;
		
		while((line = br.readLine())!=null){//为什么不是equal
			System.out.println(line);
			
		}
		br.close();

	}

}
