package thread;
/**
 * 守护线程
 * 
 * 守护线程又称为后台线程，默认创建出来的线程都是普通
 * 线程或者称为前台线程。只有调用线程的setDaemon方法后
 * 才会将该线程设置为守护线程。
 * 
 * 守护线程使用上与前台线程一样，但是在结束时机上有一点不同：
 * 当进程结束时，所有正在运行的守护线程都会被强制中断。
 * 进程的结束：当一个进程中没有任何前台线程时即结束。
 * @author zy
 *
 */

public class DaemonThreadDemo {

	public static void main(String[] args) {
		Thread rose = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

					};
					System.out.println("rose:let me go!");
				}
				System.out.println("rose was died");
			}
		};
		
		Thread jack = new Thread(){
			public void run(){
				for(int i=0;true;i++){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

					}
					System.out.println("jack:you jump! i jump!");
				}
			}
		};
		rose.start();
		jack.setDaemon(true);//设置守护线程必须要在start方法之前进行。
		jack.start();
		

	}

}
