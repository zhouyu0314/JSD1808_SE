package file;

import java.io.File;

/**
 * 删除目录
 * @author ta
 *
 */
public class DeleteDirDemo {
	public static void main(String[] args) {
		/*
		 * 将当前目录下的demo目录删除
		 */
		File dir = new File("a");
		if(dir.exists()) {
			/*
			 * delete方法在删除目录时要求该目录必须
			 * 是一个空目录。  
			 */
			dir.delete();
			System.out.println("目录已删除!");
		}else {
			System.out.println("目录不存在!");
		}
	}
}










