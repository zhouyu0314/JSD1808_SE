package thread;

/**
 * 同步块 有效的缩小同步范围可以在保证并发安全的前提下尽可能的提高并发效率。
 * 
 * 语法： synchronized(同步监视器对象){ 需用同步运行的代码片段
 * 
 * }
 * 
 * @author zy 每个实例都有锁，当一个线程拿到锁后开始执行，当时间到后会停止但是如果锁内的内容没有执行完是不会还锁的，
 *         别的线程分配到时间之后由于没有锁所以又立刻结束了
 *
 */

public class SyncDemo2 {

	public static void main(String[] args) {
		Shop s = new Shop();
		Thread t1 = new Thread() {
			public void run() {
				s.buy();

			}
		};
		Thread t2 = new Thread() {
			public void run() {
				s.buy();
			}
		};
		t2.setPriority(10);
		t1.start();
		t2.start();

	}

}

class Shop {
	/**
	 * 直接在方法上使用synchronized，那么同步监视器 对象就是当前方法所属对象，即：方法中看到的this
	 * 
	 * @return
	 */
	// public synchronized void buy(){
	public void buy() {
		Thread t = Thread.currentThread();

		// Thread.sleep(5000);
		/*
		 * 同步块有一个要求，多个线程看到的同步监视器对象必须是同一个！ 否则没有同步运行效果。 具体使用哪个对象可以结合将来实际开发需求而定。
		 */
		while (true) {
			synchronized (this) {
				System.out.println(t.getName() + "正在挑衣服。");
				System.out.println(t.getName() + "正在试衣服。");
				System.out.println("结账。");
				// Thread.sleep(5000);
			}
		}

	}
}
