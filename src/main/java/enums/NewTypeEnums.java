package enums;

/**
 * @author yangxin
 * @time 2018/12/25  11:29
 */
public enum NewTypeEnums {
    HOT_NEWS(1,"热点新闻"),
    ENTERTAINMENT_NEWS(2,"娱乐新闻"),
    TECH_NEWS(3,"科技新闻"),
    MILITARY(4,"军事新闻"),
    SPORT_NEWS(5,"体育新闻"),
    WORLD_NEWS(6,"国际新闻")
    ;

    private int type;

    private String info;

    public static NewTypeEnums stateof(int index){
        for(NewTypeEnums state:values()){
            if(state.getType()==index)
                return state;
        }
        return null;
    }

    @Override
    public String toString() {
        return "NewTypeEnums{" +
                "type=" + type +
                ", info='" + info + '\'' +
                '}';
    }

    public int getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    NewTypeEnums() {
    }

    NewTypeEnums(int type, String info) {
        this.type = type;
        this.info = info;
    }}
