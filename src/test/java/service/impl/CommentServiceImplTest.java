package service.impl;

import dao.CommentDao;
import entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author yangxin
 * @time 2018/12/25  15:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/springDao-config.xml",
            "classpath:spring/springService-config.xml"})
public class CommentServiceImplTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void insertComment() {
        Comment comment=new Comment(2,1009,"好极32");
       System.out.println(":"+commentDao.insertComment(comment));
    }

    @Test
    public void selectCommentByNew() {
        System.out.println(":"+commentDao.queryCommentByNewId(2));
    }

    @Test
    public void selectCommentByUser() {
        System.out.println(":"+commentDao.queryCommentByUserId(1009));
    }

    @Test
    public void deleteComment() {
        System.out.println(":"+commentDao.deleteComment(2,1009));
    }
}