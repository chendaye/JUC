package Learn_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tool {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 单个线程 线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 固定线程 线程池
//        ExecutorService threadPool2 = Executors.newCachedThreadPool(); // 可变大小 线程池

        try {
            for (int i = 0; i < 5; i++){
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
