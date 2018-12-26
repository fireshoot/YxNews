package service;

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
    List<Comment> selectCommentByNew(long newId);

    /*
     * 获取用户参与的评论
     * */
    List<Comment> selectCommentByUser(long userId);

    /*
    * 用户自己删除自己的评论
    * */
    int deleteComment(long commentId,long userId);
}
