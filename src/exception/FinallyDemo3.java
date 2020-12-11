package exception;
/**
 * finally 常见的一个面试题
 * 
 * 请分别描述：final，finally，finalize：
 * finalize方法是Object提供的方法，详细参看文档。
 * @author zy
 *
 */

public class FinallyDemo3 {

	public static void main(String[] args) {
		System.out.println(test("0")+","+test(null)+","+test(""));
		

	}
	public static int test(String str){
		try{
			//System.out.println();
			return str.charAt(0)-'0';
		}catch(NullPointerException e){
			return 1;
		}catch(Exception e){
			return 2;
		}finally{
			return 3;
		}
	}

}
