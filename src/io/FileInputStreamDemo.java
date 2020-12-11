package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件流读取数据
 * @author zy
 *
 */

public class FileInputStreamDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");
		byte[] data = new byte[100];
		int a = fis.read(data);
		String str = new String(data,0,a,"utf-8");
		System.out.println(str);
		
		
		
		
		
		
		
	}

}
