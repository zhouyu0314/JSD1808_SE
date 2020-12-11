package thread;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 乐观锁，不让出时间线，而是在时间线之内等待cpu
 * ReentrantReadWriteLock 可重入读写锁
 */

public class SyncDemo7 {
	static char[] a = { '*', '*', '*', '*', '*', '*', '*' };
	static char c = '-';
	static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
					lock.writeLock().lock();//修改数据写加锁
						for (int i = 0; i < a.length; i++) {
							a[i] = c;
						}
						lock.writeLock().unlock();//修改完解锁

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
					lock.readLock().lock();//读取数据用读锁但是可以很多线程同时读
						System.out.println(Arrays.toString(a));
					lock.readLock().unlock();

				}

			}
		};

		t2.start();
	}
}

