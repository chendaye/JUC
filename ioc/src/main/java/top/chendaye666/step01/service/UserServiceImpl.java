package top.chendaye666.step01.service;

import top.chendaye666.step01.dao.UserDao;
import top.chendaye666.step01.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    /**
     * todo: 写死的 每次，有不同的 UserDao 实现类，都要修改代码
     */
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
