package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 修改昵称
 * 
 * 程序启动后，要求用户输入要修改的用户名，以及新的昵称
 * 然后对该用户进行修改。
 * 若输入的用户名不存在，则提示无此用户。
 * @author zy
 *
 */

public class UpdateDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("user1.dat","rw");
		byte[] data = new byte[32];
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入需要修改的用户名：");
		String name = scan.nextLine().trim();
		boolean check = false;
		for(int i=0;i<raf.length()/100;i++){
			raf.read(data);
			String str = new String(data,"utf-8").trim();
			if(str.equals(name)){
				check = true;
				System.out.println("请输入新的昵称：");
				str = scan.nextLine();
				raf.seek(i*100+64);
				data = str.getBytes();
				data = Arrays.copyOf(data, 32);
				raf.write(data);
				raf.seek((i+1)*100);
				System.out.print("修改完毕！");
				raf.close();
				return;
				
			}
			raf.seek((i+1)*100);
			
		}
		if(!check){
			System.out.println("用户名不存在！");
		}

		raf.close();

		
		

	}

}
