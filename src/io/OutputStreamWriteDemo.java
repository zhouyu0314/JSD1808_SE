package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 字符流
 * java按照流读写的数据单位划分为：字节流与字符流
 * 由于读写文本数据是一件非常频繁的操作，对此java专门设计了一套流：字符流。
 * 字符流是以字符为单位读写数据的，虽然底层实际上还是读写字节（计算机只有二进制），
 * 但是字节与字符之间的转换工作字符流自行完成了。对此也要注意到字符流的局限性，
 * 仅适合读写文本数据。
 * 
 * java.io.Reader和java.io.Writer
 * 这两个类也是抽象类，他们分别是所有字符输入/输出流的超类，规定了字符流读写字符的相关方法。
 * 
 * 转换流：
 * java.io.InputStreamReader
 * java.io.OutputStreamWriter
 * 它们是字符流的一对常用实现类，在使用字符流读写数据时，作为流链接的重要一环存在。
 * 但实际应用时我们通常不会直接操作这两个流（因为其上还是链接其他高级的字符流）。
 * @author zy
 *
 */
public class OutputStreamWriteDemo {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("osw.txt");
		/*
		 * 在创建转换流时，第二个参数为指定的字符集，这样通过转换流写出的文本数据
		 * 都会以该字符集转换为字节后写出。
		 */
		OutputStreamWriter ows = new OutputStreamWriter(fos,"utf-8");
		ows.write("在一瞬间有一个百万个可能，");
		ows.write("该向前走还是继续等。");
		System.out.println("写出完毕！");
		ows.close();
		
		
		

	}

}
