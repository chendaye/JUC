package proxy.springaop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import proxy.springaop.service.UserServiceImp;
import proxy.springaop.service.UserService;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService)context.getBean("userServiceImp");
        userService.add();
    }
}
