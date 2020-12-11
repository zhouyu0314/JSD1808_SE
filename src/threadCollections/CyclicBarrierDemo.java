package threadCollections;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        /**
         * 执行7次，即可退出
         */
            CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
                System.out.println("退出成功！");
            });
            //第二个参数是Runnable类型，可以直接用lamba表达式

/*        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("退出成功！");
            }
        });*/

        for (int i = 1; i <= 7; i++) {
            final int temp = i; // lambda不能操作到 i，所以加一个final的temp
            new Thread(() -> {
                System.out.println("第" + Thread.currentThread().getName() + "线程执行完毕");
                try {
                    cyclicBarrier.await(); // 等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}


