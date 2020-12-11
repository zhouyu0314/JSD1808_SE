package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池是一个管理线程的机制。它主要解决两个问题：
 * 1：重用线程
 * 2：控制线程数量
 * 频繁的创建和销毁线程会给系统带来额外的开销，所以线程应当
 * 得以重用。
 * 当线程数量过多时，会出现资源消耗增大，CPU出现过度切换导致
 * 并发性能降低。对此线程的数量也要得以控制在当前硬件环境所能
 * 承受的范围内。
 * @author zy
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for(int i=0;i<5;i++){
			Runnable r = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t.getName()+"：正在执行任务。。。");
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(t.getName()+"：执行任务完毕。。。");
				}
			};
			//将任务交给线程池
			threadPool.execute(r);
			System.out.println("将一个任务指派给了线程池!");
		}
		threadPool.shutdownNow();
		System.out.println("结束线程池！");
	}

}
