package top.chendaye666.step03.autowried;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class Auto {
    @Resource // java 原生注解，类似Autowired，有区别
    private Dog dog;
    @Autowired // 在属性 或者 setter 上使用
    @Qualifier(value = "cat") //显示指定 bean
    private Cat cat;
    private String name;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
