package threadCollections;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo03 {
    // 业务中，一般比较的是一个个对象。第二个参数是初始版本号
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);

    public static void main(String[] args) {

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp(); // 获得版本号 1
            System.out.println("版本号 => " + stamp);

            try {
                TimeUnit.SECONDS.sleep(1); //睡眠1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Lock lock = new ReentrantLock(true);

            atomicStampedReference.compareAndSet(1, 2,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);//将值改为2 版本号2

            System.out.println("版本号 => " + atomicStampedReference.getStamp());//2

            System.out.println("捣乱线程执行：" + atomicStampedReference.compareAndSet(2, 1,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));//将值改为1 版本号3

            System.out.println("版本号 => " + atomicStampedReference.getStamp());//3

        }, "a").start();


        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp(); // 获得版本号1
            System.out.println("期望获取的版本号 => " + stamp);//1

            //休息长时间，让捣乱线程执行
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("期望线程执行：" + atomicStampedReference.compareAndSet(1, 6,
                    stamp, stamp + 1));//期望值1 新值6 版本号1 新版本号2 此步修改不成功，当前 值1 版本号3

            System.out.println("版本号 => " + atomicStampedReference.getStamp());

        }, "b").start();

    }
}

