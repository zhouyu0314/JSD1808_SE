package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型应用最广泛的地方就是集合，而集合中使用泛型是用来
 * 约束集合的元素类型的
 * @author zy
 *
 */

public class CollectionDemo4 {
	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		for(int str:c){
			System.out.println(str);
		}
		
		/*
		 * 迭代器指定的泛型与其遍历的集合指定的泛型一致即可
		 */
		Iterator<Integer> it = c.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println(i);
		}
		
	}
}
