package enums;

/**
 * @author yangxin
 * @time 2018/12/25  9:46
 */
public enum UserRegisterEnums {
    SUCCESS(1,"成功"),
    FAIL(0,"注册失败"),
    INNER_ERROR(-1,"系统异常"),
    EXIST(-2,"用户已存在"),
    NOTEXIST(-3,"用户不存在"),
    UPDATEFAIL(-4,"更新失败")
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


