package juc.basic;

import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws InterruptedException {
        // 开启一个线程
        new Thread().start();
        // 枚举类，列举了线程的状态
        // Thread.State
        // cpu 核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        TimeUnit.DAYS.sleep(1);

    }
}
