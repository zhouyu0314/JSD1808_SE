package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		FileInputStream fis = null;
		byte[] data = new byte[100];
		StringBuilder builder = new StringBuilder();
		try {
			fis = new FileInputStream("aaa.txt");
			int num = fis.read(data);
			System.out.println(new String(data,0,num,"utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
