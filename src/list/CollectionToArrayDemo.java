package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection中提供了一个方法：toArray
 * 可以将当前集合转换为一个数组
 * @author zy
 *
 */

public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);
		System.out.println();
		String[] str = c.toArray(new String[c.size()]);
		System.out.println(str.length);
		System.out.println(Arrays.toString(str));
	}
}
