package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 遍历集合元素
 * 
 * Collection提供了一个方法：
 * Iterator iterator()
 * 该方法可以获取一个用于遍历当前集合元素的迭代器。
 * 
 * java.util.Iterator接口
 * 该接口是所有迭代器的顶级接口，规定了迭代器遍历集合的
 * 统一操作。不同的集合实现类都实现了一个用于遍历自身元素
 * 的迭代器实现类。我们无需记住他们，用接口接收他们并调用
 * 相应遍历方法即可。
 * @author zy
 *
 */

public class IteratorDemo {
	public static void main(String[] args) {
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
		System.out.println(c);
		
		Iterator it = c.iterator();
		/*
		 * 使用迭代器遍历集合遵循的原则：
		 * 问，取，删
		 * 其中删除元素不是必须操作
		 * 
		 * boolean hasNext()
		 * 通过迭代器判断集合是否还有元素可以遍历
		 * 
		 * E next()
		 * 获取下一个遍历的元素
		 */
		while(it.hasNext()){
			String str = (String)it.next();
			System.out.println(str);
			if("#".equals(str)){
				/*
				 * 迭代器要求在遍历的过程中不得使用集合的方法
				 * 增删元素，否则会抛出异常
				 */
//				c.remove(str);
				it.remove();
			}
		}
		System.out.println(c);
		
		
		List<String> list = new ArrayList<String>();
		
		list.add("1");
		list.add("*");
		list.add("2");
		list.add("*");
		list.add("3");
		list.add("*");
		list.add("4");
		list.add("*");
		System.out.println(list);
		
		Iterator<String> its = list.iterator();
		
		while(its.hasNext()){
			String data = its.next();
			if("*".equals(data)){
				its.remove();
			}
		}
		System.out.println(list);
		

	}
}
