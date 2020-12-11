package reflect;

import java.lang.reflect.Method;

/**
 * 通过反射的方式调用方法
 * @author zy
 *
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		p.sayHello();
		/*
		 * 利用反射方式
		 */
		//1加载类对象
		Class cla = Class.forName("reflect.Person");
		//2通过类对象实例化
		Object obj = cla.newInstance();
		//3获取无参的sayHello方法
		Method m = cla.getDeclaredMethod("sayHello", null);
		//4调用该方法
		m.invoke(obj, null);
		/*
		 * Method类的每一个实例用于表示一个类中的一个方法
		 * 其提供了动态调用该方法的操作：
		 * invoke(Object o,Object[] arg)
		 * 第一个参数为调用哪个实例的对应方法，第二个参数为
		 * 调用该对应方法时传递的实际参数。
		 */
		
	}
}
