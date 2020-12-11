package file;

import java.io.File;

/**
 * java.io.File
 * File用来表示文件系统中的一个文件或目录
 * 使用File可以:
 * 1:访问其表示的文件或目录的属性信息(名字，大小等信息)
 * 2:创建或删除文件及目录
 * 3:访问一个目录中的子项
 * 
 * 但是File不能访问文件数据。
 * 
 * @author ta
 *
 */
public class FileDemo {
	public static void main(String[] args) {
		/*
		 * 访问当前项目目录下的demo.txt文件
		 * 
		 * 相对路径的优势时可以跨平台跨环境，但是相对
		 * 的路径要根据实际运行环境而定。
		 * 在eclipse中运行java程序时，eclipse指定的
		 * "当前目录"是当前程序所在的项目目录。
		 * 这里是JSD1808_SE这个目录。
		 */
		File file = new File("./demo.txt");
		//获取名字
		String name = file.getName();
		System.out.println(name);
		System.out.println(file.getParent());
		System.out.println(file.getPath());
		
		//获取长度(单位是字节)
		long len = file.length();
		System.out.println(len);
		
		boolean cr = file.canRead();
		boolean cw = file.canWrite();
		System.out.println("可读:"+cr);
		System.out.println("可写:"+cw);
		
		boolean ih = file.isHidden();
		System.out.println("是否隐藏:"+ih);
		
	}
}















