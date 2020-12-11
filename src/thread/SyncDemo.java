package thread;
/**
 * 多线程并发的安全问题
 * 当多个线程并发操作统一资源时，由于线程切换时机的不确定和不可控
 * ，会导致操作该资源的代码逻辑执行顺序未按照设计要求运行，出现了
 * 操作混乱。严重时可能导致系统瘫痪。
 * @author zy
 *
 */

public class SyncDemo {
	
	public static void main(String[] args) {
		Table tab = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int b1 = tab.getBean();
					Thread.yield();

					System.out.println(getName()+":"+b1);
				}
				
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int b2 = tab.getBean();
					Thread.yield();

					System.out.println(getName()+":"+b2);
				}
				
			}
		};
		t1.start();
		t2.start();
		
	}
}
class Table{
	/**
	 * 解决并发安全问题的核心就是将多个线程抢着运行改为
	 * 有先后顺序的排队运行。
	 * Java提供了锁机制，强制多个线程同步运行一个方法
	 * 
	 * 当一个方法上使用关键字：synchronized修饰后，
	 * 该方法称为同步方法，多个线程不能同时在方法内部运行。
	 */
	private int beans = 20;

	public synchronized int getBean(){
		if(beans == 0){
			throw new RuntimeException("没有豆子了！");
		}
		/*
		 * yield方法会让运行这个方法的线程立刻让出CPU时间
		 * 在这里是为了模拟发生线程切换。
		 */
		Thread.yield();
		return beans--;
	}
}

	
