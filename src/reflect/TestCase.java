package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestCase {
	public static void main(String[] args) 
			throws ClassNotFoundException, 
			InstantiationException, 
			IllegalAccessException, 
			IllegalArgumentException, 
			InvocationTargetException {
		Scanner scan = new Scanner(System.in);
		String className = scan.nextLine();
		System.out.println("className:" + className);
		
		//利用java反射加载类并且将类实例化
		Class cls = Class.forName(className);
		Object obj = cls.newInstance();
		System.out.println("obj:"+obj);
		//获得所有公开的方法
		Method[] methods = cls.getDeclaredMethods();
		//遍历
		for(Method mh:methods){
			//获得方法名
			String mName = mh.getName();
			System.out.println(mName);
			
			//获得方法的参数类型信息
			Class[] types = mh.getParameterTypes();
			//如果types长度为0;该方法不带参
			Object returnVal = null;
			if(types.length==0){
				//调用方法(不带参)
				returnVal = mh.invoke(obj);
			}else{
				//如果带参
				//创建一个与参数数量相等的数组，用来存放参数值
				Object[] params = new Object[types.length];
				//依据方法的参数类型，进行相应的赋值
				for(int i=0;i<types.length;i++){
					if(types[i] == String.class){
						params[i]="hello";
					}
					if(types[i] == int.class){
						params[i]=100;
					}
				}
				//调用带有参数的方法
				returnVal = mh.invoke(obj, params);
			}
			
			System.out.println(returnVal);
		}

		
	}
}
