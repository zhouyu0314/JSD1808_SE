package thread;

import java.util.Arrays;

/**
 * 互斥锁
 * 当synchronized同时锁定多段代码片段时，并且他们指定
 * 的同步监视器对象是【同一个】时，那么这些代码片段之间就是互斥的，
 * 即：多个线程不能同时执行这些代码片段。
 * 加在方法上抢的是当前实例的锁
 * 加在静态方法上抢的是类的锁
 * @author zy
 *
 */

public class SyncDemo5 {
	static char[] a = { '*', '*', '*', '*', '*', '*', '*' };
	static char c = '-';

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
					synchronized (a) {
						for (int i = 0; i < a.length; i++) {
							a[i] = c;
						}
					}
	
					c = c == '*' ? c = '-' : '*';
				}
			}

		};
		t1.start();
		;

		Thread t2 = new Thread() {
			@Override
			public void run() {
				while (true) {
					synchronized (a) {
						System.out.println(Arrays.toString(a));
					}
					
				}

			}
		};

		t2.start();
	}
}

