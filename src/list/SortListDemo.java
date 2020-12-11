package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * 集合有一个工具类：java.util.Collections
 * 它提供了很多便于我们操作集合的静态方法，其中有一个方法是：
 * sort，由于对List几个进行自然排序。
 * @author zy
 *
 */

public class SortListDemo {

	public static void main(String[] args) {
		Random rand = new Random();
		List<Integer> l = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			l.add(rand.nextInt(100));
		}
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);

	}

}
