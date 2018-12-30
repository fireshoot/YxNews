package dao;

import dto.CommentData;
import entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangxin
 * @time 2018/12/24  15:00
 */
public interface CommentDao {

    /*
    * 添加评论
    * */
    int insertComment(Comment comment);

    /*
    * 根据新闻获取评论
    * */
    List<CommentData> queryCommentByNewId(@Param("newId") long newId);

    /*
     * 根据新闻获取评论
     * */
    List<CommentData> queryAllComment();




    /*
    * 显示用户参与的评论
    * */
    List<Comment> queryCommentByUserId(@Param("userId") long userId);

    /*
     * 根据id查询
     * */
    Comment queryCommentById(@Param("commentId") long commentId);

    /*
    * 用户自己删除评论
    * */
    int deleteComment(@Param("commentId") long commentId,@Param("userId") long userId);

}
