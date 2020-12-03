package Unsafe_Collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<String, String>(16, 0.75f);
//        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        //todo: ConcurrentModificationException 并发修改异常
        for (int i = 0; i < 10; i++){
            new Thread(() -> {
                map.put(UUID.randomUUID().toString().substring(0, 5), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
