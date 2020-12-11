package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase2 {

	public static void main(String[] args) throws 
	ClassNotFoundException, 
	InstantiationException, 
	IllegalAccessException, 
	IllegalArgumentException, 
	InvocationTargetException {
		Class cls = Class.forName("reflect.B");
		Object obj = cls.newInstance();
		Method[] methods = cls.getDeclaredMethods();
		for(Method mh:methods){
			//获得加载该方法前的注解
			Test test = mh.getDeclaredAnnotation(Test.class);
			System.out.println("test:"+test);
			//只执行带有@Test注解的方法
			if(test!=null){
				mh.invoke(obj);
				//读取@Test注解的属性值
				String v1 = test.value();
				System.out.println("v1:"+v1);
			}
		}
	}

}
