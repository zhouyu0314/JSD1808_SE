package thread;

/**
 * 第二种创建线程的方式： 实现Runnable接口，单独定义线程任务
 * 
 * @author zy
 *
 */

public class ThreadDemo2 {

	public static void main(String[] args) {
		// 实例化任务
		Runnable mr1 = new MyRunnable1();
		Runnable mr2 = new MyRunnable2();

		// 创建线程
		Thread t1 = new Thread(mr1);
		Thread t2 = new Thread(mr2);
		t1.start();
		t2.start();

	}

}

class MyRunnable1 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("你是谁？");
		}
	}

}

class MyRunnable2 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("我是查水表的！");
		}
	}
}
