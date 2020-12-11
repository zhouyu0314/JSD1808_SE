package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 删除集合元素
 * @author zy
 *
 */
public class RemoveDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(4,5));
		c.add(new Point(7,8));
		c.add(new Point(0,0));
		c.add(new Point(1,2));
		System.out.println(c);
		Point p = new Point(1,2);
		/*
		 * remove方法删除元素时是删除与给定元素equals比较为true的元素。注意：
		 * List集合而言，若存在重复元素，只删除一个。
		 */
		c.remove(p);
		System.out.println(c);
	}
}
