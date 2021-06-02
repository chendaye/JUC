package juc.Unsafe_Collection;

import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest {
    public static void main(String[] args) {
//        HashSet<String> set = new HashSet<>();
        // 集合工具类
//        Set<String> set = Collections.synchronizedSet(new HashSet<String>());
        // juc
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        //todo: ConcurrentModificationException 并发修改异常
        for (int i = 0; i < 30; i++){
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
