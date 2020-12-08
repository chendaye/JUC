package juc.Learn_Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * todo: 可重入锁
 */
public class Reenter {
    //todo: synchronized 是可重入的
    public static void main(String[] args) {
        new Thread(Phone::sms, "A").start();

        new Thread(Phone::sms, "B").start();
    }


}

class Phone{
    public synchronized static void sms(){
        System.out.println(Thread.currentThread().getName()+"：sms");
        call();
    }

    public synchronized static void call(){
        System.out.println(Thread.currentThread().getName()+"：call");
    }
}

class Reenter2{
    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();
        new Thread(phone2::sms, "A").start();

        new Thread(phone2::sms, "B").start();
    }
}

class Phone2{
    ReentrantLock lock = new ReentrantLock();
    public  void sms(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"：sms");
            call();
        } finally {
            lock.unlock();
        }

    }

    public  void call(){

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"：call");
            call();
        } finally {
            lock.unlock();
        }

    }
}
