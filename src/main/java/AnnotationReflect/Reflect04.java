package AnnotationReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> aClass = Class.forName("AnnotationReflect.User");

        System.out.println(aClass.getName()); // 包名+类名
        System.out.println(aClass.getSimpleName()); //类名
        Field field[] = aClass.getFields(); // 获取非私有的属性
        Field[] declaredFields = aClass.getDeclaredFields(); // 获取所有定义的属性
        Method[] methods = aClass.getMethods();
        Method[] declaredMethods = aClass.getDeclaredMethods(); // 同上 本类及其父类所有方法


        // 获取指定方法(传参数类型，区分重载方法 )
        Method getName = aClass.getMethod("getName", null);
        Method setName = aClass.getMethod("setName", String.class);
        System.out.println(getName);

        // 获取构造器
        Constructor<?>[] constructors = aClass.getConstructors();

    }
}
