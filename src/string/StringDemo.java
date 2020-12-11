package string;
/**
 * JVM对String有一个优化措施，即:常量池
 * java推荐我们使用"字面量"形式创建字符串对象，因为当
 * 我们这样做时虚拟机会首先检查常量池中是否有创建过该内
 * 容的字符串对象，若有，则直接重用对象。
 * 这样做可以减少内存中出现大量内容一样的字符串对象而带
 * 来的资源消耗等问题。
 * @author ta
 */
public class StringDemo {
	public static void main(String[] args) {
		String s1 = "123abc";
		String s2 = "123abc";//重用s1对象	
		String s3 = "123abc";//重用s1对象		
		System.out.println(s1==s2);//true
		System.out.println(s1==s3);//true
		//new 则强制创建新对象
		String s4 = new String("123abc");
		System.out.println("s4:"+s4);
		System.out.println(s1==s4);//false
		System.out.println(s1.equals(s4));//true
		/*
		 * 字符串是不变对象，创建后内容不可改变，若
		 * 改变必须创建新对象。
		 */
		s1 = s1 + "!";//s1修改后创建了新对象
		System.out.println("s1:"+s1);
		//s1已经不再和s2使用同一个对象
		System.out.println(s1==s2);//false
		
		/*
		 * 编译器有一个优化措施，在编译源代码时若发现
		 * 一个计算表达式参与的值都是字面量时，会直接
		 * 进行计算并将结果编译到class文件中，所以下面
		 * 的代码会被编译器改为:
		 * String s5 = "123abc";
		 * 有时候用一个计算表达式更能说明赋值的意义，而
		 * 编译器会在编译时进行计算，对于JVM运行代码时
		 * 没有任何差别。
		 */		
		String s5 = "123"+"abc";
		System.out.println("s5:"+s5);
		System.out.println(s2==s5);	//true	

		String s = "123";
		String s6 = s + "abc";
		System.out.println("s6:"+s6);
		System.out.println(s2==s6);	//false
	}
}




