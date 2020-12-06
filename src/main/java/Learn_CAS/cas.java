package Learn_CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class cas {
    //todo:CAS 比较并交换
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);


        //todo: except: 期望值  update：想更新的值
        //todo:ABA问题
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());



    }
}

//todo: 版本号解决ABA
class ABA{
    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(2, 1);
        new Thread(() -> {
            int stamp = atomicInteger.getStamp(); // 获取当前的版本号
            System.out.println("A1=>"+stamp);
            // 延时保证 AB拿到的版本号是相同的
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.compareAndSet(
                    2,  // 期望值
                    3, // 新值
                    atomicInteger.getStamp(), // 期望的版本号
                    atomicInteger.getStamp() + 1); // 修改后的版本号

            System.out.println("A2=>"+atomicInteger.getStamp());

            atomicInteger.compareAndSet(
                    3,  // 期望值
                    2, // 新值
                    atomicInteger.getStamp(), // 期望的版本号
                    atomicInteger.getStamp() + 1); // 修改后的版本号

            System.out.println("A3=>"+atomicInteger.getStamp());

        }, "A").start();

        new Thread(() -> {
            int stamp = atomicInteger.getStamp(); // 获取当前的版本号
            System.out.println("B1=>"+stamp);
            // 延时保证 AB拿到的版本号是相同的
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicInteger.compareAndSet(
                    2,  // 期望值
                    6, // 新值
                    atomicInteger.getStamp(), // 期望的版本号
                    atomicInteger.getStamp() + 1); // 修改后的版本号

            System.out.println("B2=>"+atomicInteger.getStamp());
        }, "B").start();
    }
}