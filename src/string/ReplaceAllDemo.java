package string;
/**
 * String支持正则表达式方法3:
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足正则表达式的部分替换为给定内容
 * 
 * @author ta
 *
 */
public class ReplaceAllDemo {
	public static void main(String[] args) {
		String str = "abc123def456ghi";
		/*
		 * 将当前字符串中数字部分替换为"#NUMBER#"
		 */	
		str = str.replaceAll("[0-9]+", "#NUMBER#");
		System.out.println(str);
		
		
		String regex = "(wqnmlgb|sb|nc|mdzz|cnm|djb)";
		String message = "wqnmlgb!你个sb!你怎么这么的nc!cnm!你就是一个djb!";
		message = message.replaceAll(regex, "***");
		System.out.println(message);
		
		
	}
}











