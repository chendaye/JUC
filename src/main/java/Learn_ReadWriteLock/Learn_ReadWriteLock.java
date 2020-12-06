package Learn_ReadWriteLock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Learn_ReadWriteLock {
    public static void main(String[] args) {
        MyCache cache = new MyCache();

        for (int i = 1; i <= 6; i++){
            final String tmp = String.valueOf(i);
            new Thread(() -> {
                cache.write(tmp, tmp+"");
            }).start();
        }

        for (int i = 1; i <= 6; i++){
            final String tmp = String.valueOf(i);
            new Thread(() -> {
                cache.read(tmp);
            }).start();
        }
    }


}

class MyCache{
    private volatile HashMap<String, Object> map = new HashMap<>();

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    //todo: 写操作只能一个线程
    public void write(String key, Object value){

        lock.writeLock().lock(); // 加锁
        try {
            System.out.println(Thread.currentThread().getName()+":写"+key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写ok");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock(); // 解锁
        }

    }

    //todo: 读操作可以多个线程
    public void read(String key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+":读"+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读ok");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }

    }
}
