package thread;

import java.util.LinkedList;
import java.util.Random;

/**
 * 生产者消费者模型
 * @author zy
 *
 */
public class Producer extends Thread{
	private LinkedList<Character> list;

	public Producer(LinkedList<Character> list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		//获取小写的26个英文字母
		while (true) {
			char c = (char) ('a' + new Random().nextInt(26));

			synchronized (list) {
				list.add(c);
				System.out.println("<<" + c);
				list.notifyAll();//通知一个和通知所有个
			}
		}
		
	}
	
	
	
	
	

}
