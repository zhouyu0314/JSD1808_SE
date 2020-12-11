package thread;
/**
 * 互斥锁
 * 当synchronized同时锁定多段代码片段时，并且他们指定
 * 的同步监视器对象是【同一个】时，那么这些代码片段之间就是互斥的，
 * 即：多个线程不能同时执行这些代码片段。
 * @author zy
 *
 */

public class SyncDemo4 {

	public static void main(String[] args) {
		Foo f = new Foo();
		Thread t1 = new Thread(){
			public void run(){
			f.methodA();	
			}
		};
		Thread t2 = new Thread(){
			public void run(){
			f.methodB();
			}
		};
		t1.start();
		t2.start();
		

	}

}
class Foo{
	public synchronized void methodA(){
		try {
			System.out.println(getName()+"正在执行A方法。");
			Thread.sleep(3000);
			System.out.println(getName()+"A方法执行完毕。");
		} catch (InterruptedException e) {

		}
	}
	public synchronized void methodB(){
		try {
			System.out.println(getName()+"正在执行B方法。");
			Thread.sleep(3000);
			System.out.println(getName()+"B方法执行完毕。");
		} catch (InterruptedException e) {

		}
	}
	public String getName(){
		Thread t = Thread.currentThread();
		return t.getName();
	}
}
