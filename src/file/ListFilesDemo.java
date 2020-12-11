package file;

import java.io.File;

/**
 * 获取一个目录中的所有子项
 * @author ta
 *
 */
public class ListFilesDemo {
	public static void main(String[] args) {
		/*
		 * 获取当前目录中的所有子项
		 */
		File dir = new File(".");
		/*
		 * boolean isFile() 判断是否为文件
		 * boolean isDirectory() 判断是否为目录
		 */
		if(dir.isDirectory()) {
			File[] subs = dir.listFiles();
			for(int i=0;i<subs.length;i++) {
				System.out.println(subs[i].getName());
			}
		}
		
	}
}












