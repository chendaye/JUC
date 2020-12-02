package produce_cunsumer;

public class PC01 {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++)data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++)data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            try{
                for (int i = 0; i <= 10; i++)data.decrement();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            try{
                for (int i = 0; i <= 10; i++)data.decrement();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "BB").start();
    }
}

/**
 * 资源类： 属性 方法
 *
 * todo：生产者消费者口诀： 判断等待->业务->通知
 */
class Data{
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
//        if (number != 0){
        while (number != 0){ //todo: if 改成 while 防止 虚假唤醒
            // 等待
            this.wait();
            System.out.println(Thread.currentThread().getName()+"=>"+number);
        }
        // 生产
        number++;
        // 加完；唤醒消费者线程
        this.notifyAll();

    }

    public synchronized void decrement() throws InterruptedException{
//        if (number == 0){
        while (number == 0){
            // 等待
            this.wait();
            System.out.println(Thread.currentThread().getName()+"=>"+number);
        }
        // 消费
        number--;
        // 减完；唤醒生产者
        this.notifyAll();
    }
}