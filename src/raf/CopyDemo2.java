package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 提高每次读写的数据量，减少实际发生的读写次数，可以提高读写效率。
 * 单字节读写的模式，一半称为：随机读写
 * 一组一组字节读写的模式一般称为：块读写
 * 
 * RandomAccessFile提供了块读写的方法：
 * 
 * int  read(byte[] data)
 * 一次性读取给定字节数组总长度的字节量并存入到该数组中，返回值为实际读取
 * 到的字节量，若返回值为-1，则表示文件末尾（本次没有读取到任何字节）
 * 
 * void write(byte[] data)
 * 一次性将给定的字节数组中所有字节写出
 * 
 * void write(byte[] data,int index,int len)
 * 将给定字节数组从下标index处开始的连续len个字节一次性写出
 * 
 * @author Administrator
 *
 */

public class CopyDemo2 {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("001.jpg","r");
		RandomAccessFile copy = new RandomAccessFile("002.jpg","rw");
		byte[] b = new byte[1024*10];
		int len = 0;
		long start = System.currentTimeMillis();
		while((len=raf.read(b)) !=-1){
			copy.write(b, 0, len);
		}
		long end = System.currentTimeMillis();
		System.out.print("复制完成！耗时"+(end-start)+"ms");
		raf.close();
		copy.close();

		
	}

}













