package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 转换流
 * 
 * InputStreamReader与OutputStreamWriter之所以称为"转换流"，
 * 是因为其他的高级字符流都只能链接在其他的字符流上，而不能直接链接在字节流上，而转换流是
 * 唯一可以连接在字节流上的字符流，而他们本身是字符流，可以供其他字符流连接，
 * 从而起到承上启下的作用。对此我们在使用字符流操作时，他们在流链接中是用来衔接字节流与 字符流的桥梁。负责将字符与字节之间相互转换。
 * 
 * @author zy
 *
 */

public class InputStreamReaderDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * 从osw.txt文件中读取文本数据
		 */
		FileInputStream fis = new FileInputStream("osw.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		int d;
		/*
		 * int read() 字符流定义的该方法时读取一个字符，实际从数据源读取了几个字节取决于字符集，但是当读取到该
		 * 字符后在java内部都是以unicode编码保存，就变为固定的2字节的char了。
		 */

		/*
		 * while((d = isr.read())!= -1){
		 * 
		 * System.out.print((char)d); }
		 */

		char[] data = new char[100];
		int len = isr.read(data);
		System.out.print(new String(data, 0, len));
		isr.close();

	}

}
