package dto;

import entity.User;
import enums.UserRegisterEnums;

/**
 * @author yangxin
 * @time 2018/12/25  9:59
 */
public class ResgisterState {
    private long userId;

    private int state;

    private String stateInfo;

    private User user;

    @Override
    public String toString() {
        return "ResgisterState{" +
                "userId=" + userId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", user=" + user +
                '}';
    }

    public ResgisterState(long userId, UserRegisterEnums resgisterState) {
        this.userId = userId;
        this.state = resgisterState.getState();
        this.stateInfo = resgisterState.getStateInfo();
    }


    public ResgisterState(long userId, UserRegisterEnums resgisterState, User user) {
        this.userId = userId;
        this.state = resgisterState.getState();
        this.stateInfo = resgisterState.getStateInfo();
        this.user = user;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
