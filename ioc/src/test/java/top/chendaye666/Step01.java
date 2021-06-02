package top.chendaye666;

import top.chendaye666.step01.service.UserService;
import top.chendaye666.step01.service.UserServiceImpl;

public class Step01 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }
}
