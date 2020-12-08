package juc.JMM.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * todo: 懒汉模式
 */
public class Lazy {
    private static boolean flag = false;
    private Lazy() {
        System.out.println(Thread.currentThread().getName());

        synchronized (Lazy.class){
            if (install != null){
                if (!flag){
                    flag = true; // 防止反射破坏
                }else{
                    throw new RuntimeException("不要使用反射破坏单例");
                }
            }
        }
    }

    /**
     * todo: 避免指令重排
     */
    private static volatile Lazy install;

    public static Lazy getInstance(){
        if (install == null){
            synchronized (Lazy.class){
                if (install == null){
                    //todo: 非原子性操作
                    // 1.分配内存空间
                    // 2.执行构造方法，初始化对象
                    // 3.把对象指向空间
                    //todo: 正常顺序是  1 2 3； 系统指令重排之后 可能 1 3 2，此时对象还没有完成构造，但是已经分配空间 install != null
                    install = new Lazy();
                }
            }
        }

        return install;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (int i = 1; i <= 10; i++){
            new Thread(() -> {
                Lazy.getInstance();
            }, String.valueOf(i)).start();
        }

        //todo: 反射可以破坏单例
        Lazy instance = Lazy.getInstance();

        Constructor<Lazy> constructor = Lazy.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Lazy instance1 = constructor.newInstance();

        System.out.println(instance == instance1); // false
    }
}
