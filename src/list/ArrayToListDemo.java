package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 数组转换为集合
 * 数组的工具类Arrays提供了一个静态方法：asList
 * 可以将一个数组转换为一个List集合。
 * @author zy
 *
 */

public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] str = {"one","two","three","four"};
		System.out.println(Arrays.toString(str));
		/*
		 * 通过Arrays的asList将数组转换的集合表示的就是该数组，所以对集合元素操作就是
		 * 对该数组元素操作。
		 */
		List<String> l = Arrays.asList(str);
		System.out.println(l);
		
		l.set(0, "1");
		System.out.println(l);
		System.out.println(Arrays.toString(str));
//		由于数组是定长的，所以该集合不可以增删元素。
//		l.add(0, "11");
//		System.out.println(l);
		/*
		 * 若希望对集合增删元素，需要自行创建一个集合并导入该集合元素
		 */
//		List<String> l1 = new ArrayList<String>();
//		l1.addAll(l);
//		l1.add("five");
		/*
		 * 所有的集合都支持一个参数为Collection的构造方法，
		 * 作用是在创建当前集合的同时包含给定集合中的所有元素
		 */
		
		List<String> l1 = new ArrayList<String>(l);
		l1.add("five");
		System.out.println(l1);
		System.out.println(l);
	}

}
