package service;

import dto.CommentData;
import entity.Comment;

import java.util.List;

/**
 * @author yangxin
 * @time 2018/12/25  14:16
 */
public interface CommentService {


    /*
    * 添加评论
    * */
    int insertComment(Comment comment);

    /*
    * 获取文章下的评论
    * */
    List<CommentData> selectCommentByNew(long newId);

    /*
     * 获取用户参与的评论
     * */
    List<Comment> selectCommentByUser(long userId);

    /*
     * 获取所有的评论
     * */
    List<CommentData> selectAllComment();

    /*
     * 根据ID获取评论
     * */
   Comment selectCommentById(long commentId);


    /*
    * 用户自己删除自己的评论
    * */
    int deleteComment(long commentId,long userId);
}
