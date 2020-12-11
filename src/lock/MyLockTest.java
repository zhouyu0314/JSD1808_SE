package lock;

import java.util.concurrent.locks.Lock;

public class MyLockTest {
    private Lock lock = new MyLock();


    public void methodA(){
        lock.lock();
        System.out.println("methodA");
        methodB();
        lock.unlock();
    }

    public void methodB(){
        lock.lock();
        System.out.println("methodB");
        lock.unlock();

    }
    public static void main(String[] args) {
        MyLockTest lock = new MyLockTest();
        lock.methodA();

    }
}
