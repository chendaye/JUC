package juc.JMM.Singleton;

public class Holder {
    private Holder(){}

    public static Holder getInstance(){
        return InnerClass.instance;
    }

    public static class InnerClass{
        private static final Holder instance = new Holder();
    }
}
