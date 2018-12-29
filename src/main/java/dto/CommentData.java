package dto;

import entity.Comment;
import entity.New;
import entity.User;

/**
 * @author yangxin
 * @time 2018/12/29  15:24
 */
public class CommentData {
    private boolean success;

    private Comment comment;

    private String username;

    @Override
    public String toString() {
        return "CommentData{" +
                "success=" + success +
                ", comment=" + comment +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

}
