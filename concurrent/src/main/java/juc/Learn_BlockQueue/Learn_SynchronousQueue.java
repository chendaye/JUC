package juc.Learn_BlockQueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * todo: 队列中只能有一个元素
 */
public class Learn_SynchronousQueue {
    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+":put 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName()+":put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName()+":put 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+":"+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+":"+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+":"+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();
    }


}
