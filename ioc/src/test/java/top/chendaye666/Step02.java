package top.chendaye666;

import top.chendaye666.step02.dao.UserDaoImpl;
import top.chendaye666.step02.dao.UserMysqlDaoImpl;
import top.chendaye666.step02.service.UserService;
import top.chendaye666.step02.service.UserServiceImpl;

public class Step02 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl)userService).setUserDao(new UserDaoImpl());
        ((UserServiceImpl)userService).setUserDao(new UserMysqlDaoImpl());
        userService.getUser();
    }
}
