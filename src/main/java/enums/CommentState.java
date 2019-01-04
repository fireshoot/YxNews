package enums;

/**
 * @author yangxin
 * @time 2019/1/4  11:18
 */
public enum CommentState {
    SUCCESS(1,"操作成功"),
    FAIL(-2,"操作失败"),
    UNOPERATION(-3,"无权限"),
    INTERBUSY(-4,"网络忙"),
    UNLOGIN(-10,"未登录"),

    ;


    private int state;

    private String stateInfo;

    public static CommentState stateof(int index){
        for(CommentState state:values()){
            if(state.getState()==index)
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

    CommentState(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
}


