package juc.Learn_Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Test02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //todo: Thread 只接受 Runnable; FutureTask 是 Runnable 的实现类；FutureTask 又调用 Callable
        // todo: 间接实现 Thread 使用 Callable
        MyThread02 thread02 = new MyThread02();
        FutureTask<String> futureTask = new FutureTask<>(thread02);
        new Thread(futureTask, "A").start();

        // 返回结果；可能会阻塞(线程执行时间长)；结果会缓存
        String s = futureTask.get();
    }
}

class MyThread02 implements Callable<String> {

    @Override
    public String call() {
        System.out.println("call()");
        return "123";
    }
}
