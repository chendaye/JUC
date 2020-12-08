package juc.AnnotationReflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * todo: 通过反射获取注解信息(框架就是如此)
 */
public class Reflect07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("juc.AnnotationReflect.Person");

        // 通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation );
        }

        // 获取具体的注解值
        Table annotation = c1.getAnnotation(Table.class);
        String value = annotation.value();

        // 获取属性上的注解
        Field name = c1.getDeclaredField("name");
        FieldName annotation2 = name.getAnnotation(FieldName.class);
        String field = annotation2.field();
        String table = annotation2.table();
    }
}

@Table("chendaye666 ")
class Person{
    @FieldName(table = "姓名", field = "age")
    private String name;
    private int age;

    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@interface Table{
    String value();
}


@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE,ElementType.FIELD})
@interface FieldName{
    String table() default "";
    String field();
}