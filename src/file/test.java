package file;
/**
 * 完成方法，实现将给定的File对象表示的而文件或目录删除
 * 
 * 完成1+2+3+4+5+。。。。+100，整段代码不得出现for，while关键字。
 * 
 * 
 * 买汽水，一块钱一瓶汽水，两个空瓶换一瓶汽水，三个瓶盖换一瓶汽水，20块钱可以喝到多少瓶？
 */

import java.io.File;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		test t = new test();
		t.show();
		
	}
	public void show(){
		System.out.print("��������Ҫɾ�����ļ�/�ļ������֣�");
		File file = new File(name());
		delete(file);
		
	}
	public void delete(File f){
		if(!f.exists()){
			System.out.println("�ļ������ڣ�");
			return;
		}
		if(f.isDirectory()){
			File[] subs = f.listFiles();
			for(int i=0;i<subs.length;i++){
				File sub = subs[i];

				//先删除当前子项
				/*
				 * 递归调用
				 * 一个方法内部调用自己方法的现象称为递归调用。
				 * 使用递归要注意：
				 * 1。递归调用一定是在一个分支语句中控制的，
				 * 如果方法部必定调用当前方法则是死循环。
				 * 2。递归调用的层数不宜过多，因为会大量的消耗内存，并且执行速度慢。（能不用尽量不用。）
				 */
				delete(sub);
			}
		}
			f.delete();
			System.out.println("�ļ���ɾ����");

		
		
		
		
		
		
		
		
		
	}
	public String name(){
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		return str;
	}



}
