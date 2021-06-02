package juc.JMM.Singleton;

/**
 * todo: 枚举本身也是一个类
 *  枚举防止 反射破坏单例
 *
 *  todo: javap -p *class  自带反编译字节码
 *          jad -sjava *.class  jad工具反编译 
 */
public enum  EnumSignle {
    INSTANCE;
    public EnumSignle getInstance(){
        return INSTANCE;
    }

}

class Test{
    public static void main(String[] args) {
        EnumSignle instance = EnumSignle.INSTANCE;
        EnumSignle instance2 = EnumSignle.INSTANCE;
    }
}
