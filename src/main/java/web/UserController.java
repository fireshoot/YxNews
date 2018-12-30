package web;

import dto.*;
import entity.Comment;
import entity.New;
import entity.User;
import enums.UserRegisterEnums;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CommentService;
import service.NewService;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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
    private HttpSession session;

    @Autowired
    private NewService newService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    /*
    * 跳转登录页面
    * */
    @RequestMapping(value = "/login1.html")
    public String login(){
        return "login";
    }

    /*
     * 跳转主页页面，目前弃用
     * */
    @RequestMapping(value = "/index.html")
    public  String index(Model model ){
        NewList newList = newService.selectIndexNew();
        List<NewsData> newsData = newService.selectAllNews();
        model.addAttribute("list",newList);
        model.addAttribute("newData",newsData);
        return "NewIndex";
    }

    /*
    * 跳转到注册页面
    * */
    @RequestMapping(value = "/register.html")
    public String register(){
        return "register";
    }

    /*
    * 跳转到找回密码
    * */
    @RequestMapping(value = "/forgetpassword.html")
    public String forgetpassword(){
        return "ForgetPassword";
    }


    /*
    * 跳转到管理员登录
    * */
    @RequestMapping(value = "/adminLogin.html")
    public String adminLogin(){
        return "AdminLogin";
    }

    /*
    * 跳转到用户中心
    * */
    @RequestMapping(value = "/center.html")
    public String center(Model model){
        User user = (User) session.getAttribute("user");
        if(user!=null){//表示已经登录

            List<NewsData> list = newService.selectNewsByUserId(user.getUserId());
            List<CommentData> list1 = commentService.selectCommentByUser(user.getUserId());

            model.addAttribute("news",list);
            model.addAttribute("comment",list1);
            return "NewsAndComment";
        }else{
            NewsResult<String> result=new NewsResult<>(false,"未登录");
            model.addAttribute("result",result);
            return "redirect:/user/index.html";
        }

    }


    /*
    * 实现注册逻辑.
    * 1：优化，在极端时间中，同时注册相同Username(原数据库中没有)，会导致同时插入非法数据。
    *    解决思路：使用Redis做二级缓存，注册时先要去缓存中去查找，如果有，那么已经被注册，表示不能注册。
    *               如果没有，注册成功的时候也往redis中插入。
    * */
    @RequestMapping(value = "/toregister")
    public String toregister(User user,Model model){
        user.setCreateTime(new Date());
        logger.info("############yangxin专用日志###########  注册功能模块的前台传来的注册数据："+user);

        User existUser=userService.selectByName(user.getUserName());
        if(existUser!=null){//说明昵称已经存在
            NewsResult<User> register=new NewsResult<User>(false, UserRegisterEnums.DBAEXIST.getStateInfo());
            model.addAttribute("result",register);
            return "register";
        }else {
            ResgisterState res=userService.register(user);
            if (res.getState()!=1){//表示不成功
                NewsResult<User> register=new NewsResult<User>(false,res.getStateInfo());
                model.addAttribute("result",register);
                return "register";
            }else{
                NewsResult<User> register=new NewsResult<User>(true,user);
                model.addAttribute("result",register);
                session.setAttribute("user",user);
                return "login";
            }
        }
    }


    /*
    * 忘记密码找回密码逻辑
    * */
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
                model.addAttribute("result",forget);
                return "ForgetPassword";
            }else{
                NewsResult<User> forget=new NewsResult<User>(true,user);
                model.addAttribute("result",forget);
                return "login";
            }
        }else{
            NewsResult<User> forget=new NewsResult<User>(false,"不存在此用户");
            model.addAttribute("result",forget);
            return "ForgetPassword";
        }
    }

    /*
    * 实现管理员登录逻辑
    * */
    @RequestMapping(value = "/toadminLogin")
    public String toadminLogin(String username,String password,Model model){
        User user=userService.login(username,password);
        if(user!=null&&user.getUserType()==2){
            NewsResult<User> result= new NewsResult<User>(true,user);
            model.addAttribute("adminresult",result);
            model.addAttribute("customer", user);
            session.setAttribute("user",user);
            return "redirect:/new/adminIndex.html";
        }else{
            NewsResult<User> result= new NewsResult<User>(false,"用户名或者密码错误或者你不是管理员");
            model.addAttribute("adminresult",result);
            return "AdminLogin";
        }
    }


    /*
     * 实现登录逻辑
     *
     * 优化：1.限制用户在多个客户端登录的限制
     *
     * */
    @RequestMapping(value = "/login")
    public String tologin(String username,
                          String password,String email,Model model){
        User user=userService.login(username,password);
        if(user!=null){
            //说明有用户，表示用户或者密码正确
            NewsResult<User> result= new NewsResult<User>(true,user);
            model.addAttribute("result",result);
            model.addAttribute("customer", user);
            session.setAttribute("user",user);
            return "redirect:/user/index.html";
        }else{
            NewsResult<User> result= new NewsResult<User>(false,"用户名或者密码错误");
            model.addAttribute("result",result);
            return "login";
        }
    }


}
