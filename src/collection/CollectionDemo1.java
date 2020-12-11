package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection
 * 
 * 集合框架
 * Collection接口是所有集合的顶级接口，规定了所有集合
 * 都应当具备的功能。
 * 其下常见的分类：
 * java.util.List:可重复集合，有序集
 * java.util.Set:不可重复集合
 * 重复指的是元素是否重复，而标准是元素自身equals比较的结果。
 * @author zy
 *
 */

public class CollectionDemo1 {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		/*
		 * boolean add(E e)
		 * 向当前集合中添加给定元素，成功添加则返回true；
		 */
		boolean a = c.add("1");
		c.add(1);
		boolean b = c.add("2");
		boolean c1 = c.add("3");
		boolean d = c.add("4");
		System.out.println(c);
		System.out.println(a+","+b+","+c1+","+d);
		
		/*
		 * int size()
		 * 返回当前集合的元素个数
		 */
		int size = c.size();
		System.out.println("size"+size);
		
		/*
		 * 判断集合是否为空集（不含有任何元素）
		 * size 为0是空集
		 */
		boolean isEmpty = c.isEmpty();
		System.out.println("isEmpty:"+isEmpty);
		/*
		 * 清空集合元素
		 */
		c.clear();
		System.out.println("集合已清空");
		System.out.println(c.size());
		System.out.println(c.isEmpty());

	}

}
