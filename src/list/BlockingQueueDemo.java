package list;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * 阻塞队列是并发安全的队列，采用双缓冲，在并发安全的前提下解决
 * 存取互斥问题，并发效率好
 * @author zy
 *
 */

public class BlockingQueueDemo {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		System.out.println(queue.poll());
		System.out.println(queue.offer("four"));
		System.out.println(queue);
		try {
			System.out.println(queue.offer("five", 5, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
