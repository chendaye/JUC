package proxy.springaop.diy;

public class SelfPointcut {
    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }
}
