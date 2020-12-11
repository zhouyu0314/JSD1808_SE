package list;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供了一对重载的add，remove方法。都是支持通过
 * 下标操作对应元素
 * @author zy
 *
 */

public class ListDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		/*
		 * void add(int index,E e)
		 * 在指定位置插入给定元素
		 */
		list.add(1,"o");
		System.out.println(list);
		/*
		 * E remove(int index)
		 * 删除并返回指定位置对应的元素
		 */
		String str = list.remove(1);
		System.out.println(list+","+str);
	}
}
