package service;

import dto.ResgisterState;
import entity.User;

/**
 * 关于用户的操作，普通用户登录注册、管理员的登录
 *
 * @author yangxin
 * @time 2018/12/25  9:18
 */
public interface UserService {

    /*
    * 注册用户，默认是普通用户，不能是管理员
    * */
    ResgisterState register(User user);

    /*
    * 根据用户名验证用户是否存在
    * */
    User selectByName(String userName);

    /*
    * 登录验证，用户名，密码
    * */
    User login(String userName,String Password);

    /*
    * 用户更新密码
    * */
    ResgisterState updateUser(User user);

}
