package AnnotationReflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class SelfAnnotation {
    //todo: 参数如果没有默认值，就有显示纺赋值
    @MyAnnotation2(name = "kk", school = {"清华"})
    public void test(){}
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@interface MyAnnotation2{
    /**
     * todo: 注解的参数： 类型 + 参数名()
     * @return
     */
    String name() default "";

    int age() default 0;

    String[] school();
}


@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@interface MyAnnotation3{
    /**
     * todo: 注解只有一个参数，建议用 value
     * @return
     */
    String value() default "";

}
