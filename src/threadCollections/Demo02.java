package threadCollections;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * casABA错误
 */
public class Demo02 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        // ============== 捣乱的线程 ==================
        System.out.println(atomicInteger.compareAndSet(1, 2));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2, 1));
        System.out.println(atomicInteger.get());
        // ============== 期望的线程 ==================
        System.out.println(atomicInteger.compareAndSet(1, 3));
        System.out.println(atomicInteger.get());
    }

}
