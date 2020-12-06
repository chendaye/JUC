package Learn_Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * todo: 自己实现一个自旋锁
 */
public class SelfLock {
    // Thread 默认 null
    AtomicReference<Thread>  atom = new AtomicReference<>();

    // 加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+":myLock");
        //自旋锁， 设置不成功就一直自旋
        while (!atom.compareAndSet(null, thread));{

        }
    }

    // 解锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+":myUnLock");
        // 解锁(设置为空)
        atom.compareAndSet(thread, null);
    }
}

class TestSelfLock{
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        //todo: 自定义自旋锁
        SelfLock selfLock = new SelfLock();
        new Thread(() -> {
            selfLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                selfLock.myUnLock();
            }
        }, "A").start();

        // 等待一段时间，保证 A先拿到锁
        TimeUnit.SECONDS.sleep(2);
        new Thread(() -> {
            selfLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                selfLock.myUnLock();
            }
        }, "B").start();

    }
}
