package web;

import dto.NewsResult;
import dto.ResgisterState;
import entity.User;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.Date;

/**
 * UserController包含有登录、注册、用户信息修改三个模块。
 * 采用RESTful设计URL接口：
 * 登录接口 ：POST/login
 * 注册：POST/user/resgister
 * 更新：POST/user/update
 * @author yangxin
 * @time 2018/12/26  9:31
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login1.html")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/index.html")
    public  String index(){
        return "index";
    }


    @RequestMapping(value = "/adminIndex.html")
    public String adminIndex(){
        return "AdminIndex";
    }

    @RequestMapping(value = "/register.html")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/forgetpassword.html")
    public String forgetpassword(){
        return "ForgetPassword";
    }


    @RequestMapping(value = "/adminLogin.html")
    public String adminLogin(){
        return "AdminLogin";
    }



    @RequestMapping(value = "/login")
    public String tologin(String username,
                          String password,String email,Model model){
        User user=userService.login(username,password);
        if(user!=null){
            //说明有用户，表示用户或者密码正确
            NewsResult<User> result= new NewsResult<User>(true,user);
            model.addAttribute("result",result);
            return "index";
        }else{
            NewsResult<User> result= new NewsResult<User>(false,"用户名或者密码错误");
            model.addAttribute("result",result);
            return "login";
        }
    }
    @RequestMapping(value = "/toregister")
    public String toregister(User user,Model model){
        Date createTime=new Date();
        user.setCreateTime(createTime);
        logger.info(""+user);

        User existUser=userService.selectByName(user.getUserName());

        if(existUser!=null){//说明昵称已经存在
            NewsResult<User> register=new NewsResult<User>(false,"用户名已经存在");
            model.addAttribute("register",register);
            return "register";
        }else {
            ResgisterState res=userService.register(user);
            if (res.getState()!=1){//表示不成功
                NewsResult<User> register=new NewsResult<User>(false,res.getStateInfo());
                model.addAttribute("register",register);
                return "register";
            }else{
                NewsResult<User> register=new NewsResult<User>(true,user);
                model.addAttribute("register",register);
                return "login";
            }
        }
    }


    @RequestMapping(value = "/toforgetpassword")
    public String toforgetpassword(String username,String email,String password,Model model)
    {
        User user=userService.selectByEmail(email,username);
        user.setUserPassword(password);
        logger.info(username+","+email+","+password);
        if (user!=null){
            ResgisterState state=userService.updateUser(user);
            if(state.getState()!=1){
                NewsResult<User> forget=new NewsResult<User>(false,state.getStateInfo());
                model.addAttribute("forget",forget);
                return "ForgetPassword";
            }else{
                NewsResult<User> forget=new NewsResult<User>(true,user);
                model.addAttribute("forget",forget);
                return "login";
            }
        }else{
            NewsResult<User> forget=new NewsResult<User>(false,"不存在此用户");
            model.addAttribute("forget",forget);
            return "ForgetPassword";
        }
    }

    @RequestMapping(value = "/toadminLogin")
    public String toadminLogin(String username,String password,Model model){
        User user=userService.login(username,password);
        if(user!=null&&user.getUserType()==2){
            NewsResult<User> result= new NewsResult<User>(true,user);
            model.addAttribute("result",result);
            return "AdminIndex";
        }else{
            NewsResult<User> result= new NewsResult<User>(false,"用户名或者密码错误或者你不是管理员");
            model.addAttribute("result",result);
            return "AdminLogin";
        }
    }
}
