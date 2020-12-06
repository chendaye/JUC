package Learn_Tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * todo: 加法计数器
 */
public class Learn_CyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7, () -> {
            System.out.println("集齐7龙珠");
        });

        for (int i = 1; i <= 7; i++){
            //todo: lambda 表达式中不能拿到 i的值，通过一个中间 final变量 取值
            // lambda 是一个匿名内部类
            final int tmp = i;
            new Thread(() -> {
                System.out.println("龙珠:"+tmp);
                try {
                    barrier.await(); //todo: 计数器+1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
