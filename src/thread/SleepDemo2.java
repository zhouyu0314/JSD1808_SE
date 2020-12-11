package thread;
/**
 * 当一个线程调用sleep方法处于阻塞状态时，其他线程调用
 * 该线程的中断方法时，那么该线程的sleep方法会立即抛出
 * 中断异常并打断睡眠阻塞。
 * @author zy
 *
 */

public class SleepDemo2 {

	public static void main(String[] args) {
		/*
		 * JDK8之前，有一个要求，即：
		 * 当一个方法中的局部内部类想引用这个方法的其他
		 * 局部变量，那么这个变量必须是final的。
		 * 好比main方法中的局部内部类huang中的run方法
		 * 里引用了main方法的局部变量lin，那么这个变量
		 * 就必须声明为final的。
		 */
		Thread lin = new Thread(){
			public void run(){
				try {
					/*
					 * 当一个线程调用sleep阻塞时，被其他线程
					 * 中断时会抛出中断异常
					 */
					Thread.sleep(65413245);
				} catch (InterruptedException e) {
					System.out.println("干嘛呢！干嘛呢！干嘛呢！");
				}
				System.out.println("都破相了！");
			}
		};
		Thread huang = new Thread(){
			public void run(){
				System.out.println("开始砸了！");
				for(int i=0;i<5;i++){
					System.out.println("80!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
					}
					
				}
				System.out.println("搞定！");
				lin.interrupt();//this interrupt lin
			}
		};
		huang.start();
		lin.start();

	}

}
