package top.chendaye666;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.chendaye666.step02.dao.UserDaoImpl;
import top.chendaye666.step02.dao.UserMysqlDaoImpl;
import top.chendaye666.step02.service.UserService;
import top.chendaye666.step02.service.UserServiceImpl;

public class Step02 {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        ((UserServiceImpl)userService).setUserDao(new UserDaoImpl());
//        ((UserServiceImpl)userService).setUserDao(new UserMysqlDaoImpl());
//        userService.getUser();

        // todo: Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //todo: 从容器中取对象
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        userServiceImpl.getUser();
    }
}
