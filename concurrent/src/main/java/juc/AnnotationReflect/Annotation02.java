package juc.AnnotationReflect;

import java.lang.annotation.*;

/**
 * todo: 元注解： 解释注解的注解
 */
public class Annotation02 {
    @MyAnnotation
    public void test(){

    }
}

//todo: 自定义一个注解

@Target(value = {ElementType.METHOD, ElementType.TYPE}) // Target:注解可以用在什么上面
@Retention(value = RetentionPolicy.RUNTIME) // 注解生效范围
@Documented // 注解是否生成在 javadoc中
@Inherited // 注解是否可以被继承
@interface MyAnnotation{

}
