package Learn_Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 基础卖票例子
 *
 * todo： 线程就是一个单独的资源类，没有任何附属操作。包含：
 *  - 属性
 *  - 方法
 *
 *
 */
public class SaleTicket02 {
    public static void main(String[] args) {
        // 多个线程操作同一个资源
        Ticket2 ticket = new Ticket2();

        // Runnable @FunctionalInterface  函数式接口 1.8 lambda表达式 (参数) -> {代码}
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 60; i++){
                    ticket.sale();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i <= 60; i++){
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i <= 60; i++){
                ticket.sale();
            }
        }, "C ").start();
    }



}


class Ticket2 {
    private int number = 50;
    ReentrantLock lock = new ReentrantLock();
    // 卖票
    public void sale(){
        lock.lock(); // 加锁
        try {
            //  业务代码
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number-- )+"张票 "+"剩余"+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock(); // 解锁
        }

    }

}
