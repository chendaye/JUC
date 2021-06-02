package juc.AnnotationReflect;

/**
 * todo: 类的加载
 */
public class Reflect02 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        /**
         * 加载链接的时候 会首先合并 静态代码块 静态方法
         * new 的时候，用对象的 数据 去初始化 Class,形成实例
         */
    }
}

class A{
    static {
        System.out.println("静态代码快 ");
        m = 300;
    }
    static int m = 100;

    public A() {
        System.out.println("构造函数！");
    }
}


/**
 * todo: 测试类初始化过程
 */
class InitTest{
    static {
        System.out.println("Main 类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
         //todo: 主动引用
        //Son son = new Son();

        //todo: 反射也可以产生主动引用
//        Class<?> aClass = Class.forName("juc.AnnotationReflect.Son");

        //todo: 不会产生引用(类初始化)
        System.out.println(Son.b); // 不会初始化 Son
        Son[] sons = new Son[5]; // 不会初始化 Son
        System.out.println(Son.m); // 不会初始化 Son（调用常量 ）
    }
}

class Father{
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
        System.out.println("static{}：m = "+Son.m);
    }
    static int m = 100;
    static final int a = 1;
}
