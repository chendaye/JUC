package juc.Learn_BlockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * todo: 阻塞队列： 队列满了，插入阻塞； 队列为空，出队阻塞
 */
public class Learn_BlockingQueue {
    public static void main(String[] args) {
        test01();
    }


    /**
     * todo；抛出异常API
     */
    public static void test01(){
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.add("a");
        queue.element(); // 取队首
        queue.remove();
    }


    /**
     * todo: 不抛出异常，返回bool
     */
    public static void test02(){
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.offer("a");
        queue.poll();
        queue.peek(); // 取队首
    }

    /**
     * todo: 等待，阻塞（一直阻塞）
     */
    public static void test03() throws InterruptedException{
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.put("a");
        queue.take();
    }

    /**
     * todo: 等待，阻塞（等待超时）
     */
    public static void test04() throws InterruptedException{
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.offer("a", 2, TimeUnit.SECONDS); // 如果队列满了，超时等待 2s
        queue.poll(2, TimeUnit.SECONDS); // 如果队列空了，超时等待 2s
    }
}
