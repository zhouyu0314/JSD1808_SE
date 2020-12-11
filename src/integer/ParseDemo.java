package integer;
/**
 * 包装类都支持一个静态方法：parseXXX(String str)
 * 该方法的作用是可以将字符串转换为对应的基本类型，但是
 * 前提是该字符串的内容正确描述了基本类型可以保存的值。
 * @author ta
 *
 */
public class ParseDemo {
	public static void main(String[] args) {
		String str = "123";		
		/*
		 * 当给定的字符串不能转换为对应的基本类型时，
		 * 会抛出NumberFormatException(数字格式异常)。
		 */
		int d = Integer.parseInt(str);
		System.out.println(d);//?
		double dou = Double.parseDouble(str);
		System.out.println(dou);//?
	}
}





