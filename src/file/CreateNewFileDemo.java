package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个文件
 * 
 * @author ta
 *
 */
public class CreateNewFileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 在当前目录下创建名为:test.txt的文件
		 * 表示文件new File("test.txt");路径默认不写或者new File("./test.txt")
		 * 表示路径（文件夹）"./user"表示项目所在位置下的user文件夹
		 * 都是当前项目所在的位置
		 */
		//File file = new File("./test.txt");
		File file = new File("a");
		/*
		 * boolean exists()
		 * 判断当前File表示的文件或目录是否已经存在
		 */
		if(!file.exists()) {
			/*
			 * 创建该文件
			 * 需要注意，创建的文件所在的目录必须存在，
			 * 否则会抛出异常。
			 */
			file.createNewFile();
			System.out.println("文件已创建!");
		}else {
			System.out.println("文件已存在!");
		}
		
		
		
		
	}
}
