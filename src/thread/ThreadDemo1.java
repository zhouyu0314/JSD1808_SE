package thread;
/**
 * 线程
 * 线程可以并发执行多段代码，给我们感觉上好像这些代码在"同时运行"。
 * 
 * 创建线程有两种方式：
 * 方式一：继承Thread并重写run方法。
 * @author zy
 *
 */

public class ThreadDemo1 {

	public static void main(String[] args) {
		Thread mt1 = new MyThread1();
		Thread mt2 = new MyThread2();
		/*
		 * 启动线程要调用start方法，而不是直接调用线程的run方法。
		 */
		mt1.start();
		mt2.start();

	}

}
/**
 * 第一种创建线程的方式存在两个不足之处
 * 1：由于java是单继承的，这导致继承了Thread后就不能再继承其他类了。
 *   在实际开发中经常会继承某个超类来复用其中的方法，这导致两者不能同时继承。
 * 2：继承线程后重写run方法来定义任务，这又导致我们将任务直接定义在线程上，
 *   使得线程只能做该任务，无法并发执行其他任务，重用性变差。
 * @author zy
 *
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁？");
		}
	}
	public void run(int a){//只能执行run（），不能执行run（a）
		for(int i=0;i<1000;i++){
			System.out.println("你是A？");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的！");
		}
	}
}
