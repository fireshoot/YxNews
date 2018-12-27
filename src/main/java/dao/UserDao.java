package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangxin
 * @time 2018/12/24  14:30
 */
public interface UserDao {

    /*
    * 插入用户
    * */
     int insertUser(User user);

    /*
    * 根据昵称和密码查询用户验证登录
    * */
    User queryById(@Param("userName") String userName, @Param("userPassword") String userPassword);

    /*
    * 根据名称查找用户
    * */
    User queryByName(@Param("userName") String userName);

    /*
     * 根据id查找用户
     * */
    User queryByOnlyId(@Param("userId") long userId);

    /*
    * 更新用户信息
    * */
    int updateUser(User user);

    /*
    * 通过邮箱验证
    * */
    User queryByOnlyEmail(@Param("email") String email,@Param("userName") String userName);
}
