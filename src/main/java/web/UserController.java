package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangxin
 * @time 2018/12/26  9:31
 */
@Controller
@RequestMapping(value = "/News")
public class UserController {

    @GetMapping(value = "/login.html")
    public String login(){
        //FDSDG

        return "login";
    }
}
