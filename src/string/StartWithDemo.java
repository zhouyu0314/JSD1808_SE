package string;
/**
 * String startsWith(String str)
 * String endsWith(String str)
 * 判断字符串是否是以给定字符串开始或结尾的
 * @author ta
 *
 */
public class StartWithDemo {
	public static void main(String[] args) {
		//java编程思想
		String str = "thinking in java";
		
		boolean starts = str.startsWith("thin");
		System.out.println(starts);
		
		boolean ends = str.endsWith("ava");
		System.out.println(ends);
	}
}





