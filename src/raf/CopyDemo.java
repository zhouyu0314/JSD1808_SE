package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("001.jpg","r");
		RandomAccessFile jpg = new RandomAccessFile("002.jpg","rw");
		int d = -1;
		long start = System.currentTimeMillis();
		while((d = raf.read())!=-1){
			jpg.write(d);
			
		}
		long end = System.currentTimeMillis();
		System.out.print("写入完毕！用时："+(end-start)/1000+"秒。");
		raf.close();
		jpg.close();
		

	}

}
