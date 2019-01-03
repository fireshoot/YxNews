package dao;

import dto.CommentData;
import entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yangxin
 * @time 2018/12/24  21:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/springDao-config.xml"})
public class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void insertCommentTest(){
        Comment comment=new Comment(2,1009,"好极了");
        System.out.println(":"+commentDao.insertComment(comment));
    }

    @Test
    public void queryCommentByNewIdTest(){
        List<CommentData> list=commentDao.queryCommentByNewId(2);
        System.out.println("List<Comment>:"+list);
    }

    @Test
    public void queryCommentByUserIdTest(){
        List<CommentData> list=commentDao.queryCommentByUserId(1009);
        System.out.println("List<Comment>:"+list);
    }

    @Test
    public void deleteCommentTest(){
        System.out.println(":"+commentDao.deleteComment(1,1009));
    }

    @Test
    public void queryCommentByIdTest(){

        Comment comment=commentDao.queryCommentById(2);
        System.out.println("List<Comment>:"+comment);
    }

    @Test
    public void queryAllCommentTest(){
        System.out.println("info:"+commentDao.queryAllComment());
    }

    @Test
    public void selectCommentByLikeTest(){
        String key="好极了";
        System.out.println("List<Comment>:"+commentDao.selectCommentByLike(key));
    }

}