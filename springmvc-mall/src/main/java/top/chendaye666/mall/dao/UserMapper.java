package top.chendaye666.mall.dao;

import org.apache.ibatis.annotations.Param;
import top.chendaye666.mall.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 检查用户名是否存在
     * 需要在UserMap.xml文件里面，写该方法具体的的sql
     * @param username
     * @return
     */
    int checkUsername(String username);

    /**
     * 账号密码登录
     * @param username
     * @param passwd
     * @return
     */
    User selectLogin(@Param("username") String username, @Param("passwd") String passwd);
}