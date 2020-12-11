package file;
/**
 * 完成1+2+3+4+5+。。。。+100，整段代码不得出现for，while关键字。
 * 买汽水，一块钱一瓶汽水，两个空瓶换一瓶汽水，三个瓶盖换一瓶汽水，20块钱可以喝到多少瓶？
 */

import java.util.Scanner;

public class recursionDemo {
	private int x = 1;
	private int y ;

	public static void main(String[] args) {
		recursionDemo rec = new recursionDemo();

		System.out.print(rec.add());


	}
	
	public    int add(){

		if(x<=100){
			y = y+x++;
			add();

		}
		return y;


		
		
	}
	

}
