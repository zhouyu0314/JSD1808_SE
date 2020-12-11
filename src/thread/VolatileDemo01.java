package thread;
/**
 * t1线程启动后会死循环除非flag改成true
 * t2线程启动后会将flag改成true
 * 但是t1还是在死循环
 * 
 * volatile 保证数据的可见性
 * volatile 控制cpu 一直监听其他cpu对数据的更新，把原来告诉缓存的数据丢弃从新到物理内存复制新数据
 * @author zy
 *
 */
public class VolatileDemo01 {

	public static volatile boolean flag = false;

	public static void main(String[] args) throws InterruptedException {
		new Thread("t1"){
			@Override
			public void run() {
				while (true) {
					if(flag){
						System.out.println(Thread.currentThread().getName() + " - flag:" + flag);
						break;
					}
				}
			}
		}.start();
		
		Thread.sleep(1000);
		
		new Thread("t2"){
			@Override
			public void run() {
				flag = true;
				System.out.println(Thread.currentThread().getName() + " - flag:" + flag);
				
			}
		}.start();
	}
	
}
