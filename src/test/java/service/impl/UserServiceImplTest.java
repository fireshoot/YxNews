package service.impl;

import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * @author yangxin
 * @time 2018/12/25  14:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/springDao-config.xml",
        "classpath:spring/springService-config.xml"})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void register() {
        User user=new User(0,"yangxin666","888888","8255@qq.com",18);

        System.out.println(":"+userService.register(user));
    }

    @Test
    public void selectByName() {
        System.out.println("User:"+userService.selectByName("woshinibaba"));
    }

    @Test
    public void login() {
        System.out.println("User:"+userService.login("woshinibaba","888888"));

    }

    @Test
    public void updateUser() {
        User user=new User(0,"woshinibaba","888888","8255@qq.com",18);
        user.setUserId(1007);
        System.out.println(":"+userService.updateUser(user));
    }
}