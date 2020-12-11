package thread;
/**
 * Thread提供了一个静态方法：
 * static Thread currentThread()
 * 该方法可以获取运行这个方法的线程。
 * 
 * 后期常用的一个API：ThreadLocal里面就会用到这个方法来实现功能。
 * @author zy
 *
 */

public class CurrentThreadDemo {

	public static void main(String[] args) {
		Thread mani = Thread.currentThread();
		System.out.println("运行main方法的线程是："+mani);
		dosome();
		Thread t = new Thread(){
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println("自定义线程："+t);
				dosome();
			}
		};
		t.start();
		dosome();

	}
	public static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println("运行dosome方法的线程是："+t);
	}

}
