package web;

import Listenner.SessionListener;
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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserController包含有登录、注册、用户信息修改三个模块。
 * 采用RESTful设计URL接口：
 * 登录接口 ：POST/login
 * 注册：POST/user/resgister
 * 更新：POST/user/update
 *
 * @author yangxin
 * @time 2018/12/26  9:31
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HttpSession session;

    @Autowired
    private NewService newService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    /*
     * 跳转登录页面
     * */
    @RequestMapping(value = "/login1.html")
    public String login() {
        return "login";
    }

    /*
     * 跳转主页页面，目前弃用
     * */
    @RequestMapping(value = "/index.html")
    public String index(Model model) {
        NewList newList = newService.selectIndexNew();
        List<NewsData> newsData = newService.selectAllNews();
        model.addAttribute("list", newList);
        model.addAttribute("newData", newsData);
        return "NewIndex";
    }

    /*
     * 跳转到注册页面
     * */
    @RequestMapping(value = "/register.html")
    public String register() {
        return "register";
    }

    /*
     * 跳转到找回密码
     * */
    @RequestMapping(value = "/forgetpassword.html")
    public String forgetpassword() {
        return "ForgetPassword";
    }

    /*
     * 跳转到管理员登录
     * */
    @RequestMapping(value = "/adminLogin.html")
    public String adminLogin() {
        return "AdminLogin";
    }

    /*
     * 跳转到用户中心,未登录则条状到登录
     * */
    @RequestMapping(value = "/center.html")
    public String center(Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {//表示已经登录
            List<NewsData> list = newService.selectNewsByUserId(user.getUserId());
            List<CommentData> list1 = commentService.selectCommentByUser(user.getUserId());
            model.addAttribute("news", list);
            model.addAttribute("comment", list1);
            return "NewsAndComment";
        } else {
            NewsResult<String> result = new NewsResult<>(false, "未登录");
            model.addAttribute("result", result);
            return "redirect:/user/login1.html";
        }
    }

    /*
     * 实现注册逻辑.
     * 1：优化，在极端时间中，同时注册相同Username(原数据库中没有)，会导致同时插入非法数据。
     *    解决思路：使用Redis做二级缓存，注册时先要去缓存中去查找，如果有，那么已经被注册，表示不能注册。
     *               如果没有，注册成功的时候也往redis中插入。
     *
     *               已经处理事务
     * */
    @PostMapping(value = "/toregister")
    public String toregister(User user, Model model) {
        user.setCreateTime(new Date());
        logger.info("############yangxin专用日志###########  注册功能模块的前台传来的注册数据：" + user);
        User existUser = userService.selectByName(user.getUserName());
        if (existUser != null) {//说明昵称已经存在
            NewsResult<User> register = new NewsResult<User>(false, UserRegisterEnums.DBAEXIST.getStateInfo());
            model.addAttribute("result", register);
            return "register";
        } else {
            ResgisterState res = userService.register(user);
            if (res.getState() != 1) {//表示不成功
                NewsResult<User> register = new NewsResult<User>(false, res.getStateInfo());
                model.addAttribute("result", register);
                return "register";
            } else {
                NewsResult<User> register = new NewsResult<User>(true, user);
                model.addAttribute("result", register);
                session.setAttribute("user", user);
                return "login";
            }
        }
    }

    /*
     * 忘记密码找回密码逻辑
     * */
    @PostMapping(value = "/toforgetpassword")
    public String toforgetpassword(String username, String email, String password, Model model) {
        User user = userService.selectByEmail(email, username);
        user.setUserPassword(password);
        logger.info(username + "," + email + "," + password);
        if (user != null) {
            ResgisterState state = userService.updateUser(user);
            if (state.getState() != 1) {
                NewsResult<User> forget = new NewsResult<User>(false, state.getStateInfo());
                model.addAttribute("result", forget);
                return "ForgetPassword";
            } else {
                NewsResult<User> forget = new NewsResult<User>(true, user);
                model.addAttribute("result", forget);
                return "login";
            }
        } else {
            NewsResult<User> forget = new NewsResult<User>(false, UserRegisterEnums.NOTEXIST.getStateInfo());
            model.addAttribute("result", forget);
            return "ForgetPassword";
        }
    }

    /*
     * 实现管理员登录逻辑
     * */
    @PostMapping(value = "/toadminLogin")
    public String toadminLogin(String username, String password, Model model) {
        User adminuserCheck = userService.selectByName(username);
        ServletContext application = session.getServletContext();
        @SuppressWarnings("unchecked")
        Map<Integer, Object> loginMap = (Map<Integer, Object>) application.getAttribute("loginMap");
        if (loginMap == null) {
            loginMap = new HashMap<Integer, Object>();
        }
        for (int key : loginMap.keySet()) {
            if (adminuserCheck.getUserId() == key) {
                if (session.getId().equals(loginMap.get(key))) {
                    NewsResult<User> result = new NewsResult<User>(false,
                            adminuserCheck.getUserName() + "在同一地点重复登录");
                    model.addAttribute("adminresult", result);
                    return "AdminLogin";
                } else {
                    NewsResult<User> result = new NewsResult<User>(false,
                            adminuserCheck.getUserName() + "异地已登录，请先退出登录");
                    model.addAttribute("adminresult", result);
                    return "AdminLogin";
                }
            }
        }
        User user = userService.login(username, password);
        if (user != null && user.getUserType() == 2) {
            NewsResult<User> result = new NewsResult<User>(true, user);
            model.addAttribute("adminresult", result);
            model.addAttribute("customer", user);
            //将登录信息存入application
            loginMap.put((int) adminuserCheck.getUserId(), session.getId());
            application.setAttribute("loginMap", loginMap);
            // 将用户保存在session当中
            session.setAttribute("user", adminuserCheck);
            // session 销毁时间
            session.setMaxInactiveInterval(10 * 60);
            return "redirect:/new/adminIndex.html";
        } else {
            NewsResult<User> result = new NewsResult<User>(false, "用户名或者密码错误或者你不是管理员");
            model.addAttribute("adminresult", result);
            return "AdminLogin";
        }
    }

    /*
     * 实现登录逻辑
     *
     * 优化：1.限制用户在多个客户端登录的限制,使用application存储登录信息
     *
     * */
    @PostMapping(value = "/login")
    public String tologin(String username,
                          String password, Model model) {
        User userCheck = userService.selectByName(username);
        //检查是否已经登录
        ServletContext application = session.getServletContext();
        @SuppressWarnings("unchecked")
        Map<Integer, Object> loginMap = (Map<Integer, Object>) application.getAttribute("loginMap");
        if (loginMap == null) {
            loginMap = new HashMap<Integer, Object>();
        }
        for (int key : loginMap.keySet()) {
            if (userCheck.getUserId() == key) {
                if (session.getId().equals(loginMap.get(key))) {
                    NewsResult<User> result = new NewsResult<User>(false,
                            userCheck.getUserName() + "在同一地点重复登录");
                    model.addAttribute("result", result);
                    return "login";
                } else {
                    NewsResult<User> result = new NewsResult<User>(false,
                            userCheck.getUserName() + "异地已登录，请先退出登录");
                    model.addAttribute("result", result);
                    return "login";
                }
            }
        }
        //表示没有登录冲突
        User user = userService.login(username, password);
        if (user != null) {
            //说明有用户，表示用户或者密码正确
            NewsResult<User> result = new NewsResult<User>(true, user);
            model.addAttribute("result", result);
            //将登录信息存入application
            loginMap.put((int) userCheck.getUserId(), session.getId());
            application.setAttribute("loginMap", loginMap);
            // 将用户保存在session当中
            session.setAttribute("user", userCheck);
            logger.info("############yangxin专用日志###########  登录功能模块的插入数据："+userCheck);
            // session 销毁时间
            session.setMaxInactiveInterval(10 * 60);
            return "redirect:/user/index.html";
        } else {
            NewsResult<User> result = new NewsResult<User>(false, "用户名或者密码错误");
            model.addAttribute("result", result);
            return "login";
        }
    }

    /*
     * 实现注销登录
     * */
    @RequestMapping(value = "/Logout")
    public String Logout(String userName, Model model) {
        User usercheckLog = userService.selectByName(userName);
        userService.ForceLogout(userName);
        NewsResult<User> result = new NewsResult<User>(true, "注销成功");
        model.addAttribute("resultLogout", result);
        logger.info("############yangxin专用日志###########  注销功能模块的正常");
        if (usercheckLog.getUserType() == 2)
            return "redirect:/user/adminLogin.html";
        return "redirect:/user/login1.html";
    }

}
