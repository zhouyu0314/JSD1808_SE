package thread;
/**
 * 线程提供了一系列获取当前线程信息的方法
 * @author zy
 *
 */

public class ThreadInfoDemo {

	public static void main(String[] args) {
		//获取主线程
		Thread main = Thread.currentThread();
		//获取线程的唯一标识
		long id = main.getId();
		System.out.println("id:"+id);
		//获取线程名字
		String name = main.getName();
		System.out.println("name:"+name);
		//获取优先级
		int priority = main.getPriority();
		System.out.println("id:"+id);
		//显示活动状态
		boolean isAlive = main.isAlive();
		System.out.println("是否或者:"+isAlive);
		//显示是否为守护线程
		boolean isDaemon = main.isDaemon();
		System.out.println("是否为守护线程:"+isDaemon);
		//显示是否被中断
		boolean isInterrupted = main.isInterrupted();
		System.out.println("是否被中断:"+isInterrupted);
		

	}

}


