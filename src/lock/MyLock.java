package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 实现自己的锁
 */
public class MyLock implements Lock {
    private boolean flag = false;
    private Thread thread = null;
    private int count = 0;

    @Override
    public synchronized void lock() {
        //满足当前线程已锁，并且需要获得锁的线程不是正在持有锁的线程
        if (flag && Thread.currentThread() != thread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //当前线程持有锁
        flag = true;
        thread = Thread.currentThread();
        //重入次数+1
        count++;

    }

    @Override
    public synchronized void unlock() {
        //判断当前线程是否是持有锁的线程
        if (Thread.currentThread() == thread) {
            count --;
            if (count <= 0) {
                notify();
                flag = false;
            }

        }
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
