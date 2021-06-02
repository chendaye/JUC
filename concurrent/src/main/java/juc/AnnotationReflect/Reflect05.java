package juc.AnnotationReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * todo: 通过反射动态创建对象
 */
public class Reflect05 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> c1 = Class.forName("juc.AnnotationReflect.User");

        User user = (User) c1.newInstance(); //todo: 调用无参构造器
        System.out.println(user );

        // 通过构造器创建
        Constructor<?> declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)declaredConstructor.newInstance("long", 18, 18);
        System.out.println(user2);

        // 通过反射调用方法
        User user3 = (User) c1.newInstance();
        Method setName = c1.getMethod("setName", String.class);
        setName.invoke(user3,"666 "); // invoke: 激活， ( 对象，方法值)
        System.out.println(user3.getName());

        // 通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field age = c1.getDeclaredField("age");
        age.setAccessible(true); // 关掉权限检测； 不能直接操作私有属性
        age.set(user4, 21);

        System.out.println(user4.getAge());
    }
}
