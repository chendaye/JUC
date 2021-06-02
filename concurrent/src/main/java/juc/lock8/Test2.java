package juc.lock8;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {
        //todo: hell0 -> send 普通等待不受锁限制
        //todo: 两把锁
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(phone1::send, "A").start();

        new Thread(phone2::call, "B").start();

        new Thread(phone2::hello, "C").start();
    }

}

class Phone2{
    public synchronized void send(){
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("send");
    }

    public synchronized void call(){
        System.out.println("call");
    }

    public void hello(){
        System.out.println("hello");
    }
}
