package juc.Learn_FunctionalInterface;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * todo:函数式接口 Function：一个输入 一个输出
 *      断定型接口 Predicate： 输入一个值，返回boolean
 *      消费型接口 Consumer： 有输入，没有返回值
 *      供给型接口 Supplier： 没有参数，有返回值
 *      函数式接口 可以用 lambda 表达式简化
 *
 *
 * todo：jdk8 必会：
 *      lambda表达式
 *      链式编程
 *      函数式接口
 *      Stream流式计算
 *      
 * todo： jdk8之前 必会
 *      泛型
 *      枚举
 *      反射
 */
public class Learn_Function {
    public static void main(String[] args) {
        //todo: 看源码，传入T 返回 R

//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };

        java.util.function.Function<String, String> function = (str) -> {return str; };

        System.out.println(function.apply("aaa"));


//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };

        Predicate<String> predicate = (str)-> {return str.isEmpty();};
        System.out.println(predicate.test("123"));


//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
        Consumer<String> consumer = System.out::println;

//        Supplier<Integer> supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return 2048;
//            }
//        };

        Supplier<Integer> supplier = ()->{return 2048;};
    }
}
