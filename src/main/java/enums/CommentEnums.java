package enums;

/**
 * @author yangxin
 * @time 2019/1/4  12:40
 */
public enum CommentEnums {
    SUCCESS(1, "操作成功"),
    FAIL(-2, "操作失败"),
    UNOPERATION(-3, "无权限"),
    INTERBUSY(-4, "网络忙"),
    INSERTFAIL(-5, "插入失败"),
    ERROR(-5, "字段错误"),
    UNLOGIN(-10, "未登录"),
    INNER_ERROR(-1,"系统异常"),
    ;


    private int state;

    private String stateInfo;

    public static CommentEnums stateof(int index) {
        for (CommentEnums state : values()) {
            if (state.getState() == index)
                return state;
        }
        return null;
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

    CommentEnums(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }


}
