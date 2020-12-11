package string;
/**
 * int indexOf(String str)
 * 查找给定字符串在当前字符串中的位置，若当前字符串不包
 * 含该内容则返回值为-1
 * @author ta
 *
 */
public class IndexOfDemo {
	public static void main(String[] args) {
		//            0123456789012345
		String str = "thinking in java";
		
		int index = str.indexOf("in");
		System.out.println(index);//2
		//从指定位置开始查找第一次出现给定字符的位置
		index = str.indexOf("in", 3);
		System.out.println(index);
		//查找最后一次出现给定字符的位置
		index = str.lastIndexOf("in");
		System.out.println(index);
	}
}









