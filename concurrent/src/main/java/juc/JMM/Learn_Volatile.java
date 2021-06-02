package juc.JMM;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * todo: Volatile 保证可见性
 */
public class Learn_Volatile {
    //todo: 加 volatile 就能保证 线程t对 主存中num的修改可见
    static volatile int num = 0;
//    static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        //todo: 线程t 不知道 主内存中num的值已经修改过了
        new Thread(() -> {
            while (num == 0){
                //todo: num == 0 时一直循环
            }
        }, "t").start();

        // 等待2s 等线程 t 启动
        TimeUnit.SECONDS.sleep(2);

        //todo: 主线程在自己的工作内存中把 num 改为 1； 但是 线程t的工作内存中的值还是 0
        num = 1;
        System.out.println(num);
    }
}


/**
 * todo: Volatile 不保证原子性
 */
class Learn_Volatile2 {

    // todo: 解决方案2： 使用juc原子类型(CAS 操作)
    private static volatile AtomicInteger num = new AtomicInteger();
//    private static volatile int num = 0;

    //todo:解决方案1： 可以用 Synchronized 和 Lock 加锁保证；同一时刻只有一个线程操作
    private static void add(){
//        num++; // todo: 不是原子操作
        num.getAndIncrement(); // +1 CAS操作
    }
    public static void main(String[] args) {
        // 理论结果=20000;实际不是 20000 ；说明 volatile 不保证原子性
        for (int i = 1; i <= 20; i++){
            new Thread(() -> {
                for (int j = 0; j < 1000; j++){
                    add();
                }
            }, String.valueOf(i)).start();
        }

        //todo: 至少有2个线程： main线程、GC线程； 当线程个数=2，说明其他线程全部完了
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"num="+num);
    }
}


//todo: 通过内存屏障，禁止指令重排