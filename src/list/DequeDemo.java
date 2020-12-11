package list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列 java.util.Deque
 * 他继承自Queue，是两端都可以进出队的队列
 * 
 * 常用实现类：java.util.LinkedList
 * @author zy
 *
 */

public class DequeDemo {

	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<String>();
		deque.offer("one");
		deque.offer("two");
		deque.offer("three");
		deque.offerFirst("four");
		System.out.println(deque);
		deque.offerLast("five");
		System.out.println(deque);
		
		System.out.println(deque.poll());
		System.out.println(deque);
		System.out.println(deque.pollLast());
		System.out.println(deque);
		System.out.println(deque.pollFirst());
		System.out.println(deque);
		
		deque.push("six");
		System.out.println(deque);
		//deque.poll();
		//System.out.println(deque);
		deque.pop();
		System.out.println(deque);
		
		
	}

}
