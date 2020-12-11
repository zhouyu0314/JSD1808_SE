package string;
/**
 * String substring(int start,int end)
 * 截取当前字符串中指定范围内的内容
 * 注:在java API当中通常使用两个数字表示范围时，都是
 *    "含头不含尾"的
 * @author ta
 *
 */
public class SubstringDemo {
	public static void main(String[] args) {
		//            01234567890
		String str = "www.tedu.cn";
		//截取"tedu"
		String sub = str.substring(4, 8);
		System.out.println(sub);
		//一个参数为从指定位置截取到末尾
		sub = str.substring(4);
		System.out.println(sub);
		
	}
}







