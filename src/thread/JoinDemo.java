package thread;
/**
 * join方法可以协调线程之间同步运行
 * 
 * 异步运行：代码之间运行没有先后顺序，各干各的。
 * 同步运行：代码运行有先后顺序。
 * @author zy
 *
 */

public class JoinDemo {
	//标示图片是否下载完毕
	public static boolean isFinish = false;
	public static void main(String[] args) {
		Thread download = new Thread(){
			public void run(){
			for(int i=1;i<101;i++){	
				System.out.println("download:"+i+"%");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {

				}
			}
			System.out.println("download:下载完成！");
			isFinish = true;
			}
		};
		Thread show = new Thread(){
			public void run(){
				try {
					/*
					 * 当show线程调用download线程的join方法后
					 * 就会进入阻塞状态，直到download线程结束才会
					 * 解除阻塞。
					 */
					download.join(); //this join download 后面
				} catch (InterruptedException e) {

				}
				System.out.println("show:开始显示图片");
				/*
				 * 先等待下载线程将图片下载完毕
				 */
				if(!isFinish){
					throw new RuntimeException("show:图片加载失败！");
				}
				System.out.println("show:显示图片完毕！");
			}
		};
		download.start();
		show.start();
	}

}
