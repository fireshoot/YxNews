package enums;

/**
 * @author yangxin
 * @time 2018/12/25  11:15
 */
public enum InsertNewEnums {
    SUCCESS(1,"操作成功"),
    EXIST(0,"标题已存在"),
    NOTEXIST(-1,"文章不存在"),
    FAIL(-2,"操作失败"),
    UNOPERATION(-3,"无权限"),
    ;

    private int state;

    private String stateinfo;

    public static InsertNewEnums stateof(int index){
        for(InsertNewEnums state:values()){
            if(state.getState()==index)
                return state;
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateinfo() {
        return stateinfo;
    }

    InsertNewEnums(int state, String stateinfo) {
        this.state = state;
        this.stateinfo = stateinfo;
    }


}
