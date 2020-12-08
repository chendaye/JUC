package juc.JMM.Singleton;

/**
 * todo:饿汉式
 */
public class Hungry {

    //todo: 一开始就创建，会浪费空间
    private byte[] data = new byte[1024];
    private Hungry(){

    }

    private static final Hungry instance = new Hungry();

    public static Hungry getInstance(){
        return instance;
    }
}
