package exception;
/**
 * java异常处理机制中的try-catch
 * 语法：
 * try{
 * 可能出现的异常的代码片段
 * }catch（XXXExceptin e）{
 * 当try中出现XXXException后的解决办法
 * }
 * @author zy
 *
 */

public class TryCatchDemo {

	public static void main(String[] args) {
		System.out.println("程序开始了");
		try{
			String str = "a";
			/*
			 * 当JVM执行到某一句话时若出现了某种异常时，JVM
			 * 便会实例化对应异常的实例，并将整个代码的执行过程
			 * 设置进去，然后将该异常抛出来。
			 */
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			//System.out.println(Integer.parseInt(str));
			
			/*
			 * try语句块中出错代码以下的内容都不会运行
			 */
			System.out.println("!!!!!!");
		}catch(NullPointerException e){
			System.out.println("出现了空指针！");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("出现了字符串下标越界！");
			/*
			 * 应当养成一个好习惯，在最后一个catch中捕获Exception，
			 * 这样可以避免因为一个未捕获的异常导致程序中断。
			 */
		}catch(Exception e){
			System.out.println("出错了!");
		}


		System.out.print("程序结束了");
		
		
	}

}
