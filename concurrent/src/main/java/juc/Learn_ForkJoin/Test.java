package juc.Learn_ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * todo: 测试
 *      循环
 *      ForkJoin
 *      Stream
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test01(); // 3712
//        test02(); // 3283
        test03(); // 298
    }

    /**
     * 普通方法
     */
    public static void test01(){

        long start = System.currentTimeMillis();
        long sum = 0L;
        for (Long i = 0L; i < 10_0000_0000; i++){
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum +"执行时间："+( end - start));
    }

    /**
     * Forkjoin
     */
    public static void test02() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0L, 10_0000_0000L);
//        forkJoinPool.execute(task); // 执行任务，无结果
        ForkJoinTask<Long> ans  = forkJoinPool.submit(task);// 提交任务，有结果
        Long sum = ans. get();
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum +"执行时间："+( end - start));
    }

    /**
     * 并行流 tream
     */
    public static void test03(){
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum +"执行时间："+( end - start));

    }
}
