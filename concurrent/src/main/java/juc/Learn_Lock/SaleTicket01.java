package juc.Learn_Lock;

/**
 * 基础卖票例子
 *
 * todo： 线程就是一个单独的资源类，没有任何附属操作。包含：
 *  - 属性
 *  - 方法
 */
public class SaleTicket01 {
    public static void main(String[] args) {
        // 多个线程操作同一个资源
        Ticket1 ticket = new Ticket1();

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


class Ticket1 {
    private int number = 5000;

    // 卖票
    public synchronized void sale(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"卖出了"+(number-- )+"张票 "+"剩余"+number);
        }
    }

}
