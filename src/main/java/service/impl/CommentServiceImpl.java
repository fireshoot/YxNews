package service.impl;

import dao.CommentDao;
import dto.CommentData;
import dto.CommentState;
import entity.Comment;
import enums.CommentEnums;
import exception.CommentException;
import exception.CommentInsertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CommentService;

import java.util.List;

/**
 * @author yangxin
 * @time 2018/12/25  14:23
 */
@Service
public class CommentServiceImpl implements CommentService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentDao commentDao;

    @Override
    public CommentState insertComment(Comment comment)
            throws CommentException, CommentInsertException {
        try {
            if (comment != null) {
                int count = commentDao.insertComment(comment);
                if (count <= 0)
                    throw new CommentInsertException(CommentEnums.INSERTFAIL.getStateInfo());
                return new CommentState(comment.getCommentId(), CommentEnums.SUCCESS, comment);
            } else {
                return new CommentState(comment.getCommentId(), CommentEnums.ERROR);
            }
        } catch (CommentInsertException e1) {
            logger.error(e1.getMessage(), e1);
            return new CommentState(comment.getCommentId(), CommentEnums.INSERTFAIL);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new CommentState(comment.getCommentId(), CommentEnums.INSERTFAIL);
        }

    }

    @Override
    public List<CommentData> selectCommentByNew(long newId) {
        return commentDao.queryCommentByNewId(newId);
    }

    @Override
    public List<CommentData> selectCommentByUser(long userId) {
        return commentDao.queryCommentByUserId(userId);
    }

    @Override
    public List<CommentData> selectAllComment() {
        return commentDao.queryAllComment();
    }

    @Override
    public List<CommentData> selectCommentByLike(String key) {
        return commentDao.selectCommentByLike(key);
    }

    @Override
    public Comment selectCommentById(long commentId) {
        return commentDao.queryCommentById(commentId);
    }

    @Override
    public int deleteComment(long commentId, long userId) {
        Comment comment = commentDao.queryCommentById(commentId);
        if (comment != null) {
            if (comment.getUserId() == userId) {
                int count = commentDao.deleteComment(commentId, userId);
                if (count <= 0)
                    return 0;
                return 1;
            } else {
                return 0;
            }
        }
        return 1;
    }
}
