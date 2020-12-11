package thread;

import java.util.LinkedList;

/**
 * 生产者消费者模型
 * 
 * @author zy
 *
 */
public class Consumer extends Thread {
	private LinkedList<Character> list;

	public Consumer(LinkedList<Character> list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (list) {
				//没有数据的情况下暂停等待数据
				while(list.size()==0){
					try {
						//暂停 object
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					Character c = list.removeFirst();
					System.out.println(">>" + c);

			}
		}

	}

}
