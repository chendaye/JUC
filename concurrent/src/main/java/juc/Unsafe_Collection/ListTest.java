package juc.Unsafe_Collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("1", "2", "3");
//        list.forEach(System.out::println);

        // 并发下不安全
//        ArrayList<String> list = new ArrayList<>();
        // 解决办法 1
        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        // 解决办法 2
        List<String> list2 = new CopyOnWriteArrayList<>(); // 写入时复制；写入时避免覆盖，造成问题
        // 解决办法 3  Vector 性能没有 CopyOnWriteArrayList 好
        List<String> list3 = new Vector<>();

        //todo: 10个线程同时插入; 并发修改异常
        for (int i = 0; i < 10; i++){
            new Thread(() -> {
                list2.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list2);
            }, String.valueOf(i)).start();
        }


    }
}
