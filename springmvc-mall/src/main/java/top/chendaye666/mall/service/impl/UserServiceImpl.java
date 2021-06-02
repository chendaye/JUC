package top.chendaye666.mall.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.chendaye666.mall.common.ServerResponse;
import top.chendaye666.mall.dao.UserMapper;
import top.chendaye666.mall.pojo.User;
import top.chendaye666.mall.service.IUserService;

@Service("iUserService") // 注册为服务
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ServerResponse<User> login(String username, String password) {
        int result = userMapper.checkUsername(username);
        if (result == 0){
            return ServerResponse.ceateByErrorMessage("用户名不存在!");
        }
        //todo： MD5 密码登录

        User user = userMapper.selectLogin(username, password);
        if (user == null){
            return ServerResponse.ceateByErrorMessage("密码错误！");
        }

        // 信息正确
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功！", user);
    }
}
