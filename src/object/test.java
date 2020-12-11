package object;

import java.util.Arrays;

/**
 * 测试重写Object的相关方法
 * @author ta
 *
 */
public class test {
	public static void main(String[] args) {
		Point p = new Point(1,2);
		/*
		 * Object定义了toString方法，作用是将当前
		 * 对象转换为一个字符串。
		 * 
		 * Object提供的方法返回的字符串是当前对象
		 * 的句柄(对象的地址信息)，没有什么实际价值。
		 * 
		 * 所以通常我们在使用toString方法时就应当
		 * 重写该方法。(javaAPI提供的类都重写过该
		 * 方法了，只有我们自己定义的类需要额外重写)
		 * 
		 */
		String str = p.toString();
		System.out.println(str);
		/*
		 * System.out.println(Object o)
		 * 会将给定对象toString方法返回的字符串输出
		 */
		System.out.println(p);
		/*
		 * 字符串与其他对象链接时，也是调用该对象的
		 * toString方法先转换为字符串再与字符串链接
		 * 的。
		 */
		str = "point:" + p;
		System.out.println(str);
		
		
		
		Point p2 = new Point(1,2);
		System.out.println("p:"+p);
		System.out.println("p2:"+p2);
		
		System.out.println(p==p2);//false
		/*
		 * Object本身提供的equals比较就是值比较，
		 * 内部相当于:p==p2
		 * 所以若不重写该方法，没有实际价值。
		 */
		System.out.println(p.equals(p2));//true
	}
}











