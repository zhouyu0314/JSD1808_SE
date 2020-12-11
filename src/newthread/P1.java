package newthread;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模型
 * 生产者：依次创建A B C D E F.... X Y Z A B C D....
 * 有三个消费者：每人依次拿
 */
public class P1 {
    private LinkedList<Character> link = new LinkedList<>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {

    }


}

//生产者
class Pro extends Thread {
    private LinkedList<Character> link;
    private Lock lock;

    public Pro(LinkedList<Character> link, Lock lock) {
        this.link = link;
        this.lock = lock;
    }

    @Override
    public void run() {
        //
        int num = 0;
        while (true) {
            char c = (char) ('a' + num++);
            if (num == 25) {
                num = 0;
            }
            lock.lock();
            try {
                link.add(c);
                System.out.println("<<" + c);
            }finally {
                lock.unlock();
            }

        }

    }
}


//消费者
class Con extends Thread {
    private LinkedList<Character> link;
    private Lock lock;

    public Con(LinkedList<Character> link, Lock lock) {
        this.link = link;
        this.lock = lock;
    }

    @Override
    public void run() {

    }
}
