package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("aaa.txt","r");
		int d = raf.read();//读取第一个8位
		int c = raf.read();//读取第二个8位
		int e = raf.read();//读取第三个8位
		System.out.println(d+"+"+c+"+"+e);
		raf.close();


	}

}
