package top.chendaye666.pattern.creational.singleton;

import java.io.Serializable;

/**
 * 类加载时就创建好了。 也不存在多线程下的问题
 * 比较消耗资源
 */
public class HungrySingleton implements Serializable,Cloneable{

    private final static HungrySingleton hungrySingleton;

    static{
        hungrySingleton = new HungrySingleton();
    }
    private HungrySingleton(){
        if(hungrySingleton != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

    //todo: 防止 对象 序列化之后 再反序列化 得到不同对象。 序列化通过反射创建对象
    private Object readResolve(){
        return hungrySingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
