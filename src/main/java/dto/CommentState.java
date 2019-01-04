package dto;

import entity.Comment;
import enums.CommentEnums;

/**
 * @author yangxin
 * @time 2019/1/4  12:33
 */
public class CommentState {

    private long commentId;

    private int state;

    private String stateInfo;

    private Comment comment;

    public CommentState(long commentId, CommentEnums commentState) {
        this.commentId = commentId;
        this.state = commentState.getState();
        this.stateInfo = commentState.getStateInfo();
    }

    public CommentState(long commentId, CommentEnums commentState, Comment comment) {
        this.commentId = commentId;
        this.state = commentState.getState();
        this.stateInfo = commentState.getStateInfo();
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentState{" +
                "commentId=" + commentId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", comment=" + comment +
                '}';
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
