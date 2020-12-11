package exception;
/**
 * 通常遇到以下两种情况是我们主动向外抛出异常
 * 1：当遇到满足语法要求但是不符合业务逻辑要求时，可以主动抛出异常。
 * 2：确实程序出现了异常，但是异常不应当在当前代码片段中
 * 被解决时可以对外抛出。
 * @author zy
 *
 */

public class ThrowDemo {

	public static void main(String[] args) {
		Person p = new Person();
		try {
			/*
			 * 当调用一个含有throws声明异常抛出的方法时，编译器要求我们必须处理该异常，
			 * 而处理的方式有两种：
			 * 1：使用try-catch捕获并处理该异常。
			 * 2：在当前方法上继续使用throws声明该异常的抛出。
			 * 具体选取哪种取决于异常解决的责任问题。
			 * 注意：不要再main方法上使用throws！
			 */
			p.setAge(1000);
		} catch (IllegalAgeException e) {
			//System.out.println("报错了");
			e.printStackTrace();
		}
		System.out.println("年龄为："+p.getAge()+"岁");

	}

}
