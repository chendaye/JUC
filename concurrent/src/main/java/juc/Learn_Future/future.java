package juc.Learn_Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * todo: 异步调用
 *  异步执行（和主线程不在一条线上）
 *  成功回调
 *  失败回调
 */
public class future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //todo: 没有返回值得异步回调
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"runSync => Void");
        });
        System.out.println(222);
        //todo: 获取异步执行的结果（会阻塞 ）
        Void aVoid = future.get();

        //todo: 有返回值的异步回调
        // todo: 成功返回结果；失败返回错误信息
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"supplyAsync => Integer");
            int i = 12 / 0;
            return 2048;
        });
        System.out.println(supplyAsync.whenComplete((t, u) -> {
            System.out.println("t =>"+t);
            System.out.println("u =>"+u);
        }).exceptionally((e) -> {
            e.printStackTrace();
            return 500;
        }).get());

    }
}
