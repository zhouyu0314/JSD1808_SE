package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取字符数据
 * @author ta
 *
 */
public class ReadStringDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("aaa.txt","r");
	
		/*
		 * 读取一个字符
		 * 问题：应当读取几个字节?
		 * 除非了解该字符集编码规则。否则无法确定应当
		 * 读取多少个字节。
		 */
		//RAF也有length方法，获取其读写的文件的长度
		byte[] b = new byte[(int) raf.length()];
		int a = raf.read(b);
		String str = new String(b,"utf-8");
		System.out.println(str);
		System.out.println(a);
		raf.close();

		
	}
}











