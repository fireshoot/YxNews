package service.impl;

import dao.CommentDao;
import entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.CommentService;

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
    private CommentService commentService;

    @Test
    public void insertComment() {
        Comment comment=new Comment(2,1009,"好极32");
       System.out.println(":"+commentService.insertComment(comment));
    }

    @Test
    public void selectCommentByNew() {
        System.out.println(":"+commentService.selectCommentByNew(2));
    }

    @Test
    public void selectCommentByUser() {
        System.out.println(":"+commentService.selectCommentByUser(1009));
    }

    @Test
    public void deleteComment() {
        System.out.println(":"+commentService.deleteComment(2,1009));
    }
}