package lock8;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        //todo: 两个方法 send() call() 拿到的是同意把锁 phone；谁先拿到谁先执行
        Phone phone = new Phone();
        new Thread(phone::send, "A").start();

        // sleep 2s
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }

        new Thread(phone::call, "A").start();
    }

}

class Phone{
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
}
