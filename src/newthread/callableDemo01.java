package newthread;

import java.util.concurrent.*;

public class callableDemo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new D01();
//        FutureTask<String> futureTask = new FutureTask(callable);
//
//        new Thread(futureTask).start();
//        System.out.println(Thread.currentThread().getName() + ":Hi");
//        System.out.println(futureTask.get());
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future<String> submit = pool.submit(callable);
        System.out.println(submit.get());
    }
}


class D01 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":Hi");
        return "Hi";
    }
}
