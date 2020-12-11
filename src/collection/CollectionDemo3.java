package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c1 = new HashSet();
		c1.add("java");
		c1.add("c");
		c1.add("c++");
		System.out.println("c1:"+c1);
		
		Collection c2 = new ArrayList();
		c2.add("android");
		c2.add("ios");
		c2.add("java");
		System.out.println("c2:"+c2);
		/*
		 * 将给定集合中的所有元素添加到当前集合中（支持不同类型的集合，
		 * 注意c1的类型）
		 */
		c1.addAll(c2);
		System.out.println("c1："+c1);
		
		Collection c3 = new ArrayList();
		c3.add("java");
		c3.add("ios");
		//c3.add("vb");
		/*
		 * 判断当前集合是否包含给定集合的所有元素
		 */
		System.out.println("c1全包含c3："+c1.containsAll(c3));
		
		/*
		 * 删除交集
		 * 从当前集合中删除与给定集合中的共有元素
		 */
		Collection c4 = new ArrayList();
		c4.add("java");
		c4.add("c++");
		c1.removeAll(c4);
		System.out.println("c1:"+c1);
		
		
	}
}
