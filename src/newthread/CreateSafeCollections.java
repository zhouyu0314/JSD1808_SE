package newthread;

public class CreateSafeCollections{
    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
           synchronized (obj){
               System.out.println(Thread.currentThread().getName() + "：持有资源！");
               try {
                   obj.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName() + "：释放资源！");
           }
        },"A").start();

        Thread.sleep(1000L);

        new Thread(()->{
            synchronized (obj){
                System.out.println(Thread.currentThread().getName() + "：持有资源！");
                obj.notify();
                System.out.println(Thread.currentThread().getName() + "：释放资源！");
            }
        },"B").start();

    }




}
