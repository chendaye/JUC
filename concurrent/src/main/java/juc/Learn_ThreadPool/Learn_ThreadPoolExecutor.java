package juc.Learn_ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Learn_ThreadPoolExecutor {
    public static void main(String[] args) {
        /**
         * todo: 自定义线程池；工作中使用
         *   CPU密集型：最大线程数 设置为 核数（Runtime.getRuntime().availableProcessors() ）
         *   IO密集型： 最大线程数 > 十分耗IO的线程个数
         */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5, //todo: 核心线程数
                Runtime.getRuntime().availableProcessors(), //todo: 最大线程数
                3, //todo: 空闲存活时间
                TimeUnit.SECONDS, //todo: 时间单位
                new LinkedBlockingDeque<>(3), //todo: 阻塞队列，任务超过 核心线程数，进入队列；队列满了新建线程(< 最大线程数)
                Executors.defaultThreadFactory(), //todo: 线程工厂
                new ThreadPoolExecutor.AbortPolicy() //todo: 丢弃策略，已经达到最大线程，且队列也满了，
                // CallerRunsPolicy 哪来回哪去
                // AbortPolicy 抛出异常
                // DiscardPolicy 直接丢弃
                // DiscardOldestPolicy 丢弃队列中最老的任务
        );

        try {
            //todo: 最大承载任务= Dqueue + Max （3 + 8 ）
            for (int i = 0; i < 8; i++){
                // 用线程池，创建线程
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 线程池使用完 要关闭0
            threadPool.shutdown();
        }
    }
}
