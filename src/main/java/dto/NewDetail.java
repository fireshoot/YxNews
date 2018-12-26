package dto;

import entity.New;
import entity.User;

/**
 * @author yangxin
 * @time 2018/12/25  13:01
 */
public class NewDetail {

    private boolean success;

    private New  aNew;

    private User user;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "NewDetail{" +
                "success=" + success +
                ", aNew=" + aNew +
                ", user=" + user +
                '}';
    }

    public New getaNew() {
        return aNew;
    }

    public void setaNew(New aNew) {
        this.aNew = aNew;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
