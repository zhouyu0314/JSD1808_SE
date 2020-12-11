package exception;

import java.util.Arrays;

/**
 * finally块
 * finally块是异常处理机制的最后一块。它可以直接跟在try块
 * 之后或者最后一个catch块之后。
 * finally确保只要程序执行到try块中，那么finally块中的
 * 代码必定执行。
 * 所有通常我们将无关乎程序是否出现异常，都要执行的代码放在其中，
 * 比如IO操作后的关闭流。
 * @author zy
 *
 */

public class FinallyDemo {

	public static void main(String[] args) {
		System.out.println("程序开始");
		String str = null;
		try{

			int a = str.length();
			System.out.println("aaaa");
			return;
			
		}catch(Exception e){
			System.out.println("catch异常");
		}finally{
			System.out.println("finally运行。");
		}
		System.out.println("");


	}

}
