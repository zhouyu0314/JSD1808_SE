package list;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List
 * List接口是Clooection的一个子接口，称为线性表。
 * 
 * List集合的特点：可重复，且有序。提供了一组通过下标
 * 操作元素的方法。
 * 常见实现类：
 * java.util.ArrayList:数组实现，查询性能更好
 * java.util.LinkedList:链表实现，增删元素
 * 性能更好，尤其首尾增删元素效果最优。
 * @author zy
 *
 */

public class ListDemo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		System.out.println(list);
		for(int i=0;i<list.size();i++){
			/*
			 * E get(int index);
			 * 获取给定下标对应的元素
			 */
			System.out.println(list.get(i));
		}
		/*
		 * E set(int index,E element)
		 * 将给定元素设置到指定位置，返回值为原位置
		 * 对应的元素（被替换的元素）
		 * [A,B,C,D,E]
		 * [A,B,cc,D,E]
		 */
		String str = list.set(2, "cc");
		System.out.println(list+","+str);
	}
}
