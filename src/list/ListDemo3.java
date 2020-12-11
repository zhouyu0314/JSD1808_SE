package list;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供获取子集的操作：
 * 
 * List subList(int start,int end)
 * 获取指定范围内的子集
 * @author zy
 *
 */

public class ListDemo3 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);
		
		List<Integer> sub = list.subList(3,7);
		System.out.println(sub);
		/*
		 * 将以及元素各扩大10倍
		 * [30,40,50,60,70]
		 */
		for(int i=0;i<sub.size();i++){
			sub.set(i,sub.get(i)*10);
		}
		System.out.println(sub);
		/*
		 * 对子集元素操作就是对原集合对应元素的操作
		 */
		System.out.println(list);
		/*
		 * 将list集合中2-8删除
		 */
		list.subList(2, 9).clear();
		System.out.println(list);
	}
}
