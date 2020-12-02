package lock8;

import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) {
        //todo: 使用 class 锁
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

        new Thread(() -> {
            phone1.send();
        }, "A").start();

        new Thread(() -> {
            phone2.call();
        }, "B").start();


    }

}

class Phone3{
    //todo: static 类一加载就有方法了，这里是 class锁
    public static synchronized void send(){
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("send");
    }

    public static synchronized void call(){
        System.out.println("call");
    }

}
