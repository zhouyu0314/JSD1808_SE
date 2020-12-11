package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK5推出时，推出了一个新的特性：
 * 增强型for循环，也称为新循环，for each
 * 
 * 新循环不取代传统循环的工作，只用来遍历集合或数组。
 * 
 * 注：新循环的语法JVM是不认可的，而只是编译器认可，
 * 编译器在编译源程序时会将新循环遍历改为传统方式遍历。
 * @author zy
 *
 */

public class NewForDemo {
	public static void main(String[] args) {
		String[] arr = {"one","two","three","four"};
		/*
		 * 实际上编译器会将新循环遍历数组改为使用传统for循环式遍历
		 */
		for(String str:arr){
			System.out.println(str);
		}
		
		System.out.println("==============");
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		
		Iterator it = c.iterator();
		while(it.hasNext()){
			String str = (String)it.next();
			System.out.println(str);
			
			if("#".equals(str)){
				it.remove();
			}
		}
		System.out.println(c);
		System.out.println("==============");
		/*
		 * 新循环遍历集合就是迭代器遍历，所以在遍历的过程中不要通过集合的
		 * 方法增删元素，否则会抛出异常
		 */
		for(Object obj:c){
			if(obj instanceof String ){ 
				String s1 = (String)obj;
				System.out.println(s1);
			}

		}
	}

}
