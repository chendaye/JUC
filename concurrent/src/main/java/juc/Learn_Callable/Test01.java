package juc.Learn_Callable;

public class Test01 {
    public static void main(String[] args) {
        new Thread(new MyThread01()).start();
    }
}

class MyThread01 implements Runnable{

    @Override
    public void run() {

    }
}
