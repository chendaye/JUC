package juc.Learn_FunctionalInterface;

import java.util.Arrays;
import java.util.List;

public class Learn_Stream {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 20);
        User u2 = new User(2, "B", 22);
        User u3 = new User(3, "C", 24);
        User u4 = new User(4, "D", 26);
        User u5 = new User(5, "E", 28);

        // 集合用来存储东西
        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);

        // 流用来计算
        users.stream()
                .filter((u) -> {return u.getId() % 2 == 0;}) //  Stream<T> filter(Predicate<? super T> predicate);
                .peek((u) -> u.setAge(15))
                .map(u -> {return u.getName().toUpperCase();})
                .sorted()
                .limit(1)
                .forEach(System.out::println);
    }
}

class User{
    private int id;
    private String name;
    private int age;
    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
