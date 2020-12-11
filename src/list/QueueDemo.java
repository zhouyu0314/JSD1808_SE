package list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue接口
 * Queue是队列，其继承自Collection。
 * 队列可以保存一组元素，但是存取元素必须遵循先进先出原则
 * 
 * 常用实现类：java.util.LinkedList
 * @author zy
 *
 */

public class QueueDemo {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		/*
		 * offer方法，入队操作，将给定元素添加到队列末尾
		 */
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue);
		/*
		 * poll方法:出队操作
		 * 获取并从队列中删除队首元素
		 */
		
		Integer a = queue.poll();
		System.out.println(a);
		System.out.println(queue);
		/*
		 * peek:引用队首元素
		 * 与poll的区别在于获取后并不会将其从队列中删除
		 */
		Integer b = queue.peek();
		System.out.println(b);
		System.out.println(queue);
		/*
		 * 由于队列也是集合，所以可以使用迭代器来遍历
		 * 并且这种遍历不会影响队列中的元素
		 */
		for(Integer c:queue){
			System.out.println(c);
		}
		System.out.println(queue);
		/*
		 * 自行定义循环，利用poll方法遍历队列
		 */
		System.out.println();
		Queue<String> queue1 = new LinkedList<String>();
		queue1.offer("a");
		queue1.offer("b");
		queue1.offer("c");
		queue1.offer("d");
		while(queue1.size()>0){
			System.out.println(queue1.poll());
		}
		System.out.println(queue1);
		
		
	}

}
