package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RAF读写基本类型数据，以及RAF基于指针的读写操作
 * RAF总是在指针指向的位置要么读，要么写一个字节，
 * 并且无论是读还是写进行后，指针都会自动向后移动一个字节。
 * @author zy
 *
 */

public class RandomAccessFileDemo2 {

	public static void main(String[] args) throws IOException {
		/*
		 * 将一个int最大值写入到文件中
		 * int 最大值
		 * 01111111 11111111 11111111 11111111 21亿多
		 * 
		 * 00000000 00000000 00000000 01111111
		 * 00000000 00000000 01111111 11111111 
		 * 00000000 01111111 11111111 11111111 
		 * 01111111 11111111 11111111 11111111
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.dat","rw");
		
		/*
		 *  获取当前RAF的指针位置(指针以字节为单位)
		 *  开始时（new RandomAccessFile）是在第0位（指向第0个字符）
		 */
		
		System.out.println("pos:"+raf.getFilePointer());
		
		
		int max = Integer.MAX_VALUE;
		raf.write(max>>>24);//write 一次性只会写入一个字节，并且是低八位。 max>>>24表示向后移动24位
		System.out.println("pos:"+raf.getFilePointer());
		raf.write(max>>>16);
		raf.write(max>>>8);
		raf.write(max);
		System.out.println("pos:"+raf.getFilePointer());
		
		//一次性写4个字节，将给定的int值写出
		raf.writeInt(max);
		/*
		 * RAF对基本类型的写出方法都有所提供
		 */
		raf.writeLong(213L);
		raf.writeDouble(12.12);
		System.out.println("写出完毕！");
		System.out.println("pos:"+raf.getFilePointer());//指向第24位的字符  24位没有字符
		
		/*
		 * 移动指针位置
		 * void seek(long pos)
		 */
		//将指针移动到文件开始
		raf.seek(0);
		System.out.println(raf.getFilePointer());
		/*
		 * RAF也提供了读取基本类型数据的方法
		 * int readInt()
		 * 连续读取4字节并还原int值，若在读取4个字节的过程中发现读取到文件末尾，则直接抛出异常：
		 * EOFException     EOF:end of file
		 *  注：这个方法并不会以返回-1表示文件末尾，而是直接抛出异常，原因在于这里是真实读取4字节的int值，那么
		 *  在读取的数据中是可能读取到int型的-1的，所以就不能再用int型-1表示文件末尾了。
		 */
		int a = raf.readInt();
		System.out.println(a);
		System.out.println("pos:"+raf.getFilePointer());//4
		int b = raf.readInt();
		System.out.println(b);
		System.out.println("pos:"+raf.getFilePointer());//8
		long lo = raf.readLong();
		System.out.println(lo);
		System.out.println("pos:"+raf.getFilePointer());//15
		
		/*
		 * 修改long值为：456
		 */
		raf.seek(8);
		raf.writeLong(456);
		raf.seek(8);
		
		System.out.println(raf.readLong());
		raf.close();
		/*
		 * 一定注意 使用RandomAccessFile进行读写操作时一定先要知道指针的位置！
		 */
	}

}
