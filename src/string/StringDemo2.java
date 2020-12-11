package string;
/**
 * 频繁修改字符串代码的性能损耗
 * @author ta
 *
 */
public class StringDemo2 {
	public static void main(String[] args) {
		String str = "a";
		for(int i=0;i<10000000;i++) {
			str += "a";
		}
		System.out.println("拼接完毕!");
	}
}







