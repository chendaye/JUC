package juc.lock8;

import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) {
        //todo: 两个锁
        Phone4 phone1 = new Phone4();

        new Thread(() -> {
            phone1.send();
        }, "A").start();

        new Thread(() -> {
            phone1.call();
        }, "B").start();


    }

}

class Phone4{
    //todo:
    public static synchronized void send(){
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

}
