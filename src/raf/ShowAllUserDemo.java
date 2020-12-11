package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 显示所有用户信息
 * @author zy
 *
 */

public class ShowAllUserDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("user1.dat","r");
		byte[] data =new byte[32];
		for(int i=0;i<raf.length()/100;i++){
			raf.read(data);
			String name = new String(data,"utf-8").trim();
			raf.read(data);
			String pwd = new String(data,"utf-8").trim();
			raf.read(data);
			String nickname = new String(data,"utf-8").trim();
			int age = raf.readInt();
			System.out.println(name+","+pwd+","+nickname+","+age);
		}
		raf.close();

		
		
		

	}

}
