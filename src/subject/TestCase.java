package subject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestCase {
	public static void main(String[] args) {
//		int[] a1 = {1,2,3,4,5,6};
//		int[] a2 = {10,20,30,40,50,60};
//		System.arraycopy(a1, 0, a2, 1, 3);
//		System.out.println(Arrays.toString(a1));
//		System.out.println(Arrays.toString(a2));
//		a1 = Arrays.copyOf(a1, 7);
//		System.out.println(Arrays.toString(a1));
		LinkedListMy<String> list = new LinkedListMy();
//        System.out.println("size:"+list.getSize());
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        list.add("E");
//        System.out.println("size:"+list.getSize());
//        System.out.println(list.toString());
//        System.out.println(list.get(0));
//
//        System.out.println("remove:"+list.remove(3));
//        System.out.println(list.toString());
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			list.add("A");
		}
		System.out.println("MyLinkedList:" + list.getSize());
		long end = System.currentTimeMillis();
		System.out.println("MyLinkeList:耗时：" + (end - start));





		List<String> arr = new ArrayList<>();
		start = System.currentTimeMillis();
		for (int j = 0; j < 10000000; j++) {
			arr.add("A");
		}
		System.out.println("ArrayList:" + arr.size());
		end = System.currentTimeMillis();
		System.out.println("ArrayList:耗时：" + (end - start));


		List<String> linked = new LinkedList<>();
		start = System.currentTimeMillis();
		for (int k = 0; k < 10000000; k++) {
			linked.add("A");
		}
		System.out.println("linked:" + arr.size());
		end = System.currentTimeMillis();
		System.out.println("linked:耗时：" + (end - start));
	}
}
