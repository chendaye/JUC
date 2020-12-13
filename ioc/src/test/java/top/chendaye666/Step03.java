package top.chendaye666;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.chendaye666.step03.autowried.Auto;
import top.chendaye666.step03.autowried.People;
import top.chendaye666.step03.configuration.config.MyConfig;
import top.chendaye666.step03.configuration.pojo.User;
import top.chendaye666.step03.di.Student;
import top.chendaye666.step03.setter.Hello;

public class Step03  {
    public static void main(String[] args) {
        // 获取spring 上下文对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 对象都由 Spring管理，按需取
        Hello hello = (Hello) context.getBean("Hello");
        Hello hello2 = (Hello) context.getBean("Hello");
        System.out.println(hello.toString());
        // 容器中的类是同一个
        System.out.println(hello == hello2);


        //todo:di 依赖注入
        Student student = (Student) context.getBean("student");
        System.out.println(student.getName());
        System.out.println(student.toString());


        // autowire
        People people = (People)context.getBean("people");
        people.getCat().shut();
        people.getDog().shut();

        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("autowired.xml");
        Auto people1 = context2.getBean("auto", Auto.class);
        people1.getDog().shut();
        people1.getCat().shut();

        //@Component
        ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("annotation.xml");
        top.chendaye666.step03.annotation.Compoenet compoenet = context3.getBean("compoenet", top.chendaye666.step03.annotation.Compoenet.class);
        compoenet.say();
        compoenet.name();

        //
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        User getUser = (User) applicationContext.getBean("getUser");
        System.out.println(getUser.getName());


    }

}
