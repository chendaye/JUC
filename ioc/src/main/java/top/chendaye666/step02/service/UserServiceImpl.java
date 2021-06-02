package top.chendaye666.step02.service;

import top.chendaye666.step02.dao.UserDao;
import top.chendaye666.step02.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public void getUser() {
        userDao.getUser();
    }

    /**
     * todo: 利用 set 实现动态注入
     *      - step01:中 创建 UserDao 的 控制权 在程序手上
     *      - step01:中 创建 UserDao 的 控制权 在调用者手上
     *      - 由主动变为被动： 控制反转
     *
     *  todo：控制反转：程序不再管理对象的创建；业务耦合性大大降低，可以专注于业务
     *         - 核心： 准备好所有选项，让调用者做选择
     *         - 所谓控制反转：就是获取依赖对象的方式反转了
     *
     *   todo： DI(依赖注入)： 是 IOC的一种实现方式
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
