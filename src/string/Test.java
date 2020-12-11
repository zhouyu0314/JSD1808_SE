package string;
/**
 * 截取域名
 * @author ta
 *
 */
public class Test {
	public static void main(String[] args) {
		String u1 = "www.baidu.com";
		String u2 = "http://www.tedu.cn";
		String u3 = "http://www.sina.com.cn";
		String s1 = getHostName(u1);
		String s2 = getHostName(u2);
		String s3 = getHostName(u3);
		System.out.println(s1);//baidu
		System.out.println(s2);//tedu
		System.out.println(s3);//sina

	}
	
	public static String getHostName(String url) {
		//找第一个"."之后第一个字符的位置
		int start = url.indexOf(".")+1;
		//找第二个"."的位置
		int end = url.indexOf(".",start);
		return url.substring(start, end);
	}
}










