package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过类对象，可以获取其表示的类的一切信息
 * 类名，有哪些属性，哪些方法，哪些构造器等等。
 * 并且可以通过调用无参构造器快速实例化一个对象。
 * @author zy
 *
 */
public class ReflectDemo2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class cls = Class.forName("reflect.Person");
		/*
		 * Class提供了一个方法：newInstance
		 * 可以调用其表示的类的无参构造方法进行实例化，
		 * 并将实例化的对象返回。
		 */
		Constructor c = cls.getDeclaredConstructor(null);
		Object p1 = c.newInstance(null);
		Person p = new Person();
		System.out.println("p"+p);
		Object obj = cls.newInstance();
		System.out.println("obj"+obj);
		System.out.println("p1"+p1);
		/*
		 * 获取当前类定义的所有构造方法
		 * Constructor的每一个实例表示这个类的一个构造方法
		 */
//		Constructor[] arr = cls.getDeclaredConstructors();
//		for(Constructor con : arr){
//			System.out.println(con);
//		}
		/*
		 * 获取当前类定义的某一个构造方法
		 */
//		try {
//			Constructor c = cls.getDeclaredConstructor(String.class,int.class);
//			System.out.println(c);
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		/*
		 * 获取所有的构造方法
		 */
//		Constructor[] arr1 = cls.getConstructors();
//		for(Constructor c:arr1){
//			System.out.println(c);
//		}
		/*
		 * 获取所有方法
		 */
//		Method[] method = cls.getMethods();
//		for(Method m:method){
//			System.out.println(m);
//		}
		/*
		 * 获取所有当前类定义的方法
		 */
//		Method[] method = cls.getDeclaredMethods();
//		for(Method m:method){
//			System.out.println(m);
//		}

		
		
		
		
		
		
		
		
		
		
		
	}
}
