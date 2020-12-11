package raf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 使用RAF写出字符串
 * @author Administrator
 *
 */

public class WriteStringDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("aaa.txt","rw");
		String str = "音乐摇一摇！";
		/*
		 * String提供了将字符串转换为字节的方法
		 * byte[] getByte():按照系统默认字符集转换
		 * 
		 * byte[] getBytes(String csn)
		 * 按照置顶的字符集将字符串转换为字节，常见的字符集：
		 * GBK：国标编码，英文1字节，中文2字节
		 * utf-8:对unicode进行编码的字符集，也称为万国码
		 * 其中英文1字节，中文3字节，其他国家文字占用不等的字节量。
		 */
		byte[] b = str.getBytes("utf-8");
		raf.write(b);
		str = "哦哦哦哦哦！";
		b = str.getBytes("utf-8");
		raf.write(b);
		System.out.print("写入完毕！");
		raf.close();
		File file = new File("aaa.txt");
		System.out.print(file.length());
		
		

	}

}
