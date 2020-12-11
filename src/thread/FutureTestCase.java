package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTestCase {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		// 任务丢进线程池并获取一个凭证
		Future<?> submit = pool.submit(new R3());

		System.out.println("执行主线程");
		// 通过凭证来获取线程的结果但是run方式没返回值 所以没有结果
		submit.get();// 此相当于r1.join();
		// 销毁线程池中所有的线程，关闭线程池
		System.out.println("主线程继续执行");
		// 销毁线程池中所有的线程，关闭线程池
		pool.shutdown();
	}
}

class R3 implements Runnable {

	@Override
	public void run() {
		System.out.println("执行耗时任务.....");
		try {
			Thread.sleep(3000);
			System.out.println("任务执行结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
