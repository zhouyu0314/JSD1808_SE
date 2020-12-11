package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流完成复制操作
 * @author zy
 *
 */

public class CopyDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * 1、创建文件输入流读取源文件
		 * 2、创建文件输出流向赋值文件中写
		 * 3、循环从源文件读取一组字节，然后写入到复制文件中完成复制工作
		 * 4、使用后将流关闭
		 */
		FileInputStream fis = new FileInputStream("001.jpg");
		FileOutputStream fos = new FileOutputStream("002.jpg");
		byte[] data = new byte[1024*10];//10kb
		int a = -1;
		long start = System.currentTimeMillis();

		while((a=fis.read(data))!=-1){
			fos.write(data,0,a);
		}
		long end = System.currentTimeMillis();

		System.out.println("复制完毕！用时："+(end-start)+"ms");
		fis.close();
		fos.close();


	}

}
