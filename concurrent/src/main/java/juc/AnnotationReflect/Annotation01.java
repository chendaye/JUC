package juc.AnnotationReflect;

import java.util.ArrayList;

/**
 * todo: 内置注解
 */
public class Annotation01 extends Object {
    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated // 不推荐使用，有更好的方法
    public void test(){
        System.out.println();
    }


    @SuppressWarnings("all") // 去掉警告
    public void test02(){
        ArrayList<Integer> list = new ArrayList<>();
    }
}
