package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 使用缓冲输入流写出字符串时的缓冲区问题
 * 
 * @author zy
 *
 */

public class BufferedOutputStream_flush {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		FileOutputStream fis = new FileOutputStream("bos.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fis);
		bos.write("丝瓜鞋，一起骂，哦！".getBytes("utf-8"));
		/*
		 * void flush() 缓冲流的flush方法会强制将缓冲区中已经缓存的数据一次性写出。
		 * 频繁调用flush会降低写效率，但是可以保证写出 数据的及时性，结合实际需求使用该方法。
		 */
		bos.flush();
		System.out.println("写出完毕！");
		/*
		 * 缓冲流的close会自动调用一次flush
		 */

		bos.close();

	}

}
