package juc.AnnotationReflect;

import java.lang.annotation.ElementType;

public class Reflect01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //todo: 获取User 的 Class 对象
        // todo: Class.forName
        Class<?> c1 = Class.forName("juc.AnnotationReflect.User");
        System.out.println(c1);

        //todo: getClass() 方法获取 Class对象
        User user = new User();
        Class<? extends User> c2 = user.getClass();

        //todo: 类名.class 获取Class对象
        Class<User> c3 = User.class;

        //todo: 基本类型的包装类，可以通过TYPE获取其 Class对象
        Class<Integer> c4 = Integer.TYPE;


        // 获取父类的Class
        Class<?> superclass = c1.getSuperclass();

        /**
         * todo: 所有类型的Class
         */
        Class<Object> objectClass = Object.class;
        Class<Comparable> comparableClass = Comparable.class;
        Class<String[]> aClass = String[].class;
        Class<int[][]> aClass1 = int[][].class;
        Class<Override> overrideClass = Override.class;
        Class<ElementType> elementTypeClass = ElementType.class;
        Class<Void> voidClass = void.class;
        Class<Class> classClass = Class.class; // 本身

    }
}

class User{
    private String name;
    private int age;
    private int id;

    User(){}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
