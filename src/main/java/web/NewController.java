package web;

import dto.*;
import entity.Comment;
import entity.New;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CommentService;
import service.NewService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yangxin
 * @time 2018/12/27  14:58
 */
@Controller
@RequestMapping("/new")
public class NewController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HttpSession session;

    @Autowired
    private NewService newService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/adminIndex.html")
    public String adminIndex(Model model){
        /*
        * 待优化，采用redis缓存
        *
        * */

        /*
        * 数据有：类型名；作者名：简要描述，
        * */

        List<NewsData> list=newService.selectAllNews();
        model.addAttribute("list",list);
        return "AdminIndex";
    }

    @RequestMapping(value = "/editor.html")
    public String editor(){
        return "editor";
    }


    @RequestMapping("/detail")
    public String detail(long newId,Model model){
        NewDetail newsData=newService.selectNew(newId);
        List<CommentData> list = commentService.selectCommentByNew(newId);
        logger.info("************新闻详细信息的新闻数据***************"+newsData);
        logger.info("************新闻详细信息的评论数据***************"+list);
        model.addAttribute("detaildata",newsData);
        model.addAttribute("commentlist",list);
        return "newsdetail";
    }


    @RequestMapping(value = "/submitContent")
    public String toSubmit(New news,Model model){
       logger.info(""+news+"..");
       User user=(User)session.getAttribute("user");
       if(user!=null){
           news.setUserId(user.getUserId());
           //先确定有没有这个片文章再插入。


           /*
           *
           * 还缺少一个根据title查找的接口
           *
           * */



           InsertNewState state = newService.insertNew(news);

           if(state.getState()!=1){//表示失败
               NewsResult<New> result=new NewsResult<New>(false,state.getStateInfo());
               model.addAttribute("insertNewResult",result);
               return "editor";
           }else{
               NewsResult<New> result=new NewsResult<New>(true,news);
               model.addAttribute("insertNewResult",result);
               return "redirect:/new/adminIndex.html";
           }


       }else{
           NewsResult<New> result=new NewsResult<New>(false,"还没有登录");
           model.addAttribute("insertNewResult",result);
           return "editor";
       }
    }



    @RequestMapping(value = "/delete")
    public String delete(long newId, String userName, Model model){
        logger.info("****************"+newId+","+userName);
        User user=userService.selectByName(userName);
        InsertNewState state=newService.deleteNew(newId,user);
        if(state.getState()!=1){//不成功
            NewsResult<New> result=new NewsResult<New>(false,state.getStateInfo());
            model.addAttribute("result",result);
        }else{
            NewsResult<New> result=new NewsResult<New>(true,state.getStateInfo());
            model.addAttribute("result",result);
        }
        return "redirect:/new/adminIndex.html";
    }

    @RequestMapping(value = "/edit")
    public String editNew(long newId, String userName, Model model){
        User user=userService.selectByName(userName);
        NewDetail detail = newService.selectNew(newId);
        New news = detail.getaNew();
        if(user.getUserType()==2||user.getUserId()==news.getNewId()){
            NewsResult<NewDetail> result=new NewsResult<NewDetail>(true,detail);
            logger.info(result.getData().getaNew().getContent());
            model.addAttribute("editResult",result);
            return "editNews";
        }else{
            //如果不是作者本人或者是管理员那么不允许修改文章。
            NewsResult<New> result=new NewsResult<New>(false,"无权限");
            model.addAttribute("editResult",result);
            if(user.getUserType()==2)
                return "redirect:/new/adminIndex.html";
            else
                return "redirect:/user/index.html";
        }
    }
    @RequestMapping(value = "/update")
    public String toupdate(New news,Model model){
        logger.info(news+"");

        User user=(User)session.getAttribute("user");

        if(user!=null){
            news.setUserId(user.getUserId());
            InsertNewState state = newService.updateNews(news);
            if(state.getState()!=1){//更新失败
                NewsResult<New> newNewsResult=new NewsResult<New>( false,state.getStateInfo());
                model.addAttribute("updateResult",newNewsResult);
                return "editNews";
            }else{
                NewsResult<New> newNewsResult=new NewsResult<New>( true,news);
                model.addAttribute("updateResult",newNewsResult);
                return "redirect:/new/adminIndex.html";
            }
        }else {
            NewsResult<New> newNewsResult=new NewsResult<New>( false,"未登录");
            model.addAttribute("updateResult",newNewsResult);
            return "editNews";
        }
    }


}
