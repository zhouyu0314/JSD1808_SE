package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo2 {
	
	public static void main(String[] args) {
		ExecutorService pool;
		//pool = Executors.newFixedThreadPool(5);
		//pool = Executors.newCachedThreadPool();
		pool = Executors.newSingleThreadExecutor();
		for (int i = 1; i < 1001; i++) {
			pool.execute(new R2(i));
		}
	}
	
	
}

class R2 implements Runnable {
	//任务编号
	private int id;

	public R2(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " -任务  " + id);
	}

}
