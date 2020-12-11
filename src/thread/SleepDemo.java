package thread;
/**
 * 睡眠阻塞
 * 
 * static void sleep(long ms)
 * 该方法会让运行这个方法的线程处于阻塞状态指定的毫秒，
 * 当超时后，线程会自动回到RUNNABLE状态，等待再次
 * 获取时间片并发运行。
 * 
 * 注：一个线程进入阻塞状态时，CPU会立刻释放去并发执行其他
 * 线程，直到该线程结束阻塞状态为止。
 * @author zy
 *
 */

public class SleepDemo {

	public static void main(String[] args) {
		int num = 10;
		for(int i=num;i>=0;i--){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
			System.out.println(num--);
		}


		
		
		
		
		
		
		
		
		
		
		


	}

}
