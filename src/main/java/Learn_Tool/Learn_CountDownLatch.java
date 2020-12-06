package Learn_Tool;

import java.util.concurrent.CountDownLatch;

/**
 * todo：减法计数器，倒计时完毕会执行某个操作
 *      想象一个场景：教室里面6个学生(线程)，一个守门的老师(线程)；6个学生都走出去了再关门
 */
public class Learn_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                downLatch.countDown(); //todo: 计数器-1
            }, String.valueOf(i)).start();
        }
        // todo：等待其他线程执行完毕；计数器归零，再向下执行
        downLatch.await();

        System.out.println("close the door!");
    }
}
