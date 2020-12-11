package thread;
/**
 * 线程优先级
 * 
 * 线程无法主动获取CPU时间片，唯一可以干涉线程调度工作
 * 的方式就是修改线程优先级，最大程度的改善获取CPU时间
 * 片的几率。
 * 理论上，线程优先级越高的线程获取CPU时间片的次数越多
 * 
 * 线程有10个优先级，分别用整数1-10表示。
 * @author zy
 *
 */

public class PriorityDemo {

	public static void main(String[] args) {
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("max");
				}
			}
		};
		Thread norm = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("norm");
				}

			}
		};
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("min");
				}

			}
		};
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		max.start();
		norm.start();
		min.start();

	}

}
