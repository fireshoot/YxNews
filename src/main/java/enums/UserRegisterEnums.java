package enums;

/**
 * @author yangxin
 * @time 2018/12/25  9:46
 */
public enum UserRegisterEnums {
    SUCCESS(1,"成功"),
    FAIL(0,"注册失败"),
    INNER_ERROR(-1,"系统异常"),
    RedisEXIST(-2,"该用户名不能够被注册"),
    DBAEXIST(-5,"数据库中已存在该用户"),
    NOTEXIST(-3,"用户不存在"),
    UPDATEFAIL(-4,"更新失败"),
    UNLOGIN(-10,"未登录"),
    ;

    private int state;

    private String stateInfo;

    UserRegisterEnums(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static UserRegisterEnums stateof(int index){
        for(UserRegisterEnums state:values()){
            if(state.getState()==index)
                return state;
        }
        return null;
    }

    public int getState() {
        return state;
    }



    public String getStateInfo() {
        return stateInfo;
    }


}


