package juc.produce_cunsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Learn_Condition {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(() -> {
            for (int i = 0; i < 20; i++){
                data3.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++){
                data3.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++){
                data3.printC();
            }
        }, "C").start();

    }



}
class Data3{
    private final Lock lock = new ReentrantLock();

    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();

    private int flag = 1; // 1 : A执行 2：B执行 3 ：C执行

    public void printA(){
        lock.lock();
        try {
            while (flag != 1){
                conditionA.await();
            }
            // 业务
            System.out.println(Thread.currentThread().getName()+"->"+"A");
            flag = 2;
            conditionB.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            // 业务
            while (flag != 2){
                conditionB.await();
            }
            // 业务
            System.out.println(Thread.currentThread().getName()+"->"+"B");
            flag = 3;
            conditionC.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            // 业务
            while (flag != 3){
                conditionC.await();
            }
            // 业务
            System.out.println(Thread.currentThread().getName()+"->"+"C");
            flag = 1;
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
