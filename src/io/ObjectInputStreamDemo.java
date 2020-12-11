package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象输入流
 * @author zy
 *
 */

public class ObjectInputStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*
		 * 读取person.obj文件，将其中的对象读取回来
		 */
		FileInputStream fis = new FileInputStream("Person.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		/*
		 * 对象输入流在读取了一组字节后按照其表示的结构将其还原为对象的过程称为：对象的反序列化
		 */
		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();
		
		

	}

}
