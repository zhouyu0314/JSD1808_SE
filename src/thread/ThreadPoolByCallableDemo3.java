package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * Callable可以有返回值结果可以抛异常
 * @author zy
 *
 */
public class ThreadPoolByCallableDemo3 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Future<Double> submit = pool.submit(new R4());
		System.out.println("主程序执行");
		Double d = submit.get();
		System.out.println(d);
		pool.shutdown();
		
	}
	
}

class R4 implements Callable<Double>{

	@Override
	public Double call() throws Exception {
		System.out.println("执行耗时计算");
		Thread.sleep(3000);
		return Math.random();
	}
	
}
