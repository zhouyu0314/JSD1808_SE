package thread;
/**
 * 静态方法若使用synchronized修饰后，那么一定具有同步效果。
 * @author zy
 *
 */

public class SyncDemo3 {

	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				Boo.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				Boo.dosome();
			}
		};
		t1.start();
		t2.start();
		

	}

}
class Boo{
	public synchronized static void dosome(){

		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"正在运行。");
			Thread.sleep(5000);
			System.out.println(t.getName()+"运行结束。");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}