package juc.Learn_Tool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 限流
 */
public class Learn_Swmaphore {
    public static void main(String[] args) {
        //todo: 限制3个线程(车位)
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 8; i++){
            new Thread(() -> {
                try {
                    semaphore.acquire(); //todo: 获取车位
                    System.out.println(Thread.currentThread().getName()+":获取车位");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release(); //todo: 离开车位
                    System.out.println(Thread.currentThread().getName()+":离开车位");
                }
            }, String.valueOf(i)).start();
        }
    }
}
