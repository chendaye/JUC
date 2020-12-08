package juc.produce_cunsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PC02 {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++)data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++)data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            try{
                for (int i = 0; i <= 10; i++)data.decrement();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            try{
                for (int i = 0; i <= 10; i++)data.decrement();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "BB").start();
    }
}

/**
 * 资源类： 属性 方法
 *
 * todo：生产者消费者口诀： 判断等待->业务->通知
 */
class Data2{
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public  void increment() throws InterruptedException {
        lock.lock();

        try {
            while (number != 0){ //todo: if 改成 while 防止 虚假唤醒
                // 等待
                condition.await();
                System.out.println(Thread.currentThread().getName()+"=>"+number);
            }
            // 生产
            number++;
            // 加完；唤醒消费者线程
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException{
        lock.lock();

        try {
            while (number == 0){ //todo: if 改成 while 防止 虚假唤醒
                // 等待
                condition.await();
                System.out.println(Thread.currentThread().getName()+"=>"+number);
            }
            // 消费
            number--;
            // 唤醒生产者线程
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}