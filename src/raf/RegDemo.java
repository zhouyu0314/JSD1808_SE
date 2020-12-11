package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * 完成用户注册功能 用户信息包含：用户名，密码，昵称，年龄 其中除了年龄为int外，其余为字符串String
 * 
 * 每条记录占用100字节，其中：用户名，密码，昵称各占用32字节 年龄时固定的4字节
 * 
 * 由于字符串的实际字节量取决于字符的多少，为了格式的统一， 便于读取，也为了后期可以修改字符串内容，我们常见的作法时对字符串"留白"。
 * 将字符串的长度定的大一些，并且为固定值。
 * 
 * @author zy
 *
 */

public class RegDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * Scanner scan = new Scanner(System.in); System.out.println("请输入用户名：");
		 * String name = scan.nextLine(); System.out.println("请输入密码："); String
		 * pwd = scan.nextLine(); System.out.println("请输入昵称："); String nickName
		 * = scan.nextLine(); System.out.println("请输入年龄："); int age =
		 * Integer.parseInt(scan.nextLine()); RandomAccessFile raf = new
		 * RandomAccessFile("user1.dat","rw");
		 * 
		 * raf.seek(raf.length());
		 * 
		 * byte[] data = name.getBytes("utf-8"); data = Arrays.copyOf(data,32);
		 * raf.write(data);
		 * 
		 * data = pwd.getBytes("utf-8"); data = Arrays.copyOf(data,32);
		 * raf.write(data);
		 * 
		 * data = nickName.getBytes("utf-8"); data = Arrays.copyOf(data,32);
		 * raf.write(data);
		 * 
		 * raf.writeInt(age);
		 * 
		 * raf.close(); System.out.println("写入完毕！");
		 */

		Scanner scan = new Scanner(System.in);
		RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
		raf.seek(raf.length());
		System.out.println("请输入用户名：");
		String username = scan.nextLine();
		System.out.println("密码：");
		String password = scan.nextLine();
		System.out.println("昵称：");
		String nickname = scan.nextLine();
		System.out.println("年龄：");
		int age = Integer.parseInt(scan.nextLine());
		byte[] data = username.getBytes("utf-8");
		data = Arrays.copyOf(data, 32);
		raf.write(data);
		data = password.getBytes("utf-8");
		data = Arrays.copyOf(data, 32);
		raf.write(data);
		data = nickname.getBytes("utf-8");
		data = Arrays.copyOf(data, 32);
		raf.write(data);
		raf.writeInt(age);

	}

}
