package file;

import java.io.File;

/**
 * 创建一个多级目录
 * @author ta
 *
 */
public class MkDirsDemo {
	public static void main(String[] args) {
		/*
		 * 在当前目录下创建a/b/c/d/e/f目录
		 */
		File dir = new File("a/b/c/d/e/f");
		if(!dir.exists()) {
			/*
			 * mkdir()方法要求创建的目录所在的父目录必须
			 * 存在。
			 * mkdirs()方法则会将不存在的父目录一同创建
			 * 出来。
			 */
			dir.mkdirs();
			System.out.println("创建完毕!");
		}else {
			System.out.println("目录已存在!");
		}
		
	}
}









