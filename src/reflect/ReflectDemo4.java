package reflect;

import java.lang.reflect.Method;

/*
 * 调用有参方法
 */
public class ReflectDemo4 {
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		p.sayHello("张三");
		Class cla = Class.forName("reflect.Person");
		Object o = cla.newInstance();
		//获取sayHello(String)
		Method m = cla.getDeclaredMethod("sayHello", Class.forName("java.lang.String"));
		m.invoke(o, "张三");
		//获取sayHello(String,int)
		Method m1 = cla.getDeclaredMethod("sayHello", String.class,int.class);
		m1.invoke(o, "李四",22);
		
		
	}
}
