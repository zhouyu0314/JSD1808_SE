package threadCollections;

import java.util.concurrent.atomic.AtomicStampedReference;

public class Test1 {
    private static AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("abc",1);

    public static void main(String[] args) {
        System.out.println(atomicStampedReference.getReference());//获取abc

        atomicStampedReference.compareAndSet("abc1","bca",1,2);

        System.out.println("newReference:"+atomicStampedReference.getReference()+"---newStamp:"+atomicStampedReference.getStamp());
    }

}
