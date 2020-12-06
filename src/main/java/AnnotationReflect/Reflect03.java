package AnnotationReflect;

public class Reflect03 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        // 父类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1 );

        // 当前类的加载器
        ClassLoader classLoader = Class.forName("AnnotationReflect.Reflect03").getClassLoader();
        System.out.println(classLoader);

        // 加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
