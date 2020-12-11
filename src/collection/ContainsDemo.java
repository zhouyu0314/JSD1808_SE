package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合可以判断是否包含给定元素，方法为：
 * boolean contains(Object o)
 * 当包含给定元素时返回true
 * @author zy
 *
 */

public class ContainsDemo {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(7,8));
		c.add(new Point(9,0));
		System.out.println(c);//此处显示的值是由Point重写toString（）方法决定的
		Point p = new Point(1,2);
		/*
		 * 集合的contains方法判断时是使用元素equals的比较结果进行的。当给定元素与
		 * 集合现有元素存在equals比较为true的情况时便返回true。
		 */
		System.out.println(c.contains(p));
		
	}

}
