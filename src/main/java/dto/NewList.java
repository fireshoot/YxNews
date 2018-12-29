package dto;

import entity.New;

import java.util.List;

/**
 * 封装前端新闻显示的所有类型的新闻数据。
 * @author yangxin
 * @time 2018/12/25  10:58
 */
public class NewList {

    /*
    * 热点新闻
    * */
    private List<New> HOT_NEWS;

    /*
     * 娱乐新闻
     * */
    private List<New> ENTERTAINMENT_NEWS;

    /*
     * 科技新闻
     * */
    private List<New> TECH_NEWS;

    /*
     * 军事新闻
     * */
    private List<New> MILITARY;

    /*
     * 体育新闻
     * */
    private List<New> SPORT_NEWS;



    @Override
    public String toString() {
        return "NewList{" +
                "HOT_NEWS=" + HOT_NEWS +
                ", ENTERTAINMENT_NEWS=" + ENTERTAINMENT_NEWS +
                ", TECH_NEWS=" + TECH_NEWS +
                ", MILITARY=" + MILITARY +
                ", SPORT_NEWS=" + SPORT_NEWS +
                ", WORLD_NEWS=" + WORLD_NEWS +
                '}';
    }


    public List<New> getHOT_NEWS() {
        return HOT_NEWS;
    }

    public List<New> getENTERTAINMENT_NEWS() {
        return ENTERTAINMENT_NEWS;
    }

    public List<New> getTECH_NEWS() {
        return TECH_NEWS;
    }

    public List<New> getMILITARY() {
        return MILITARY;
    }

    public List<New> getSPORT_NEWS() {
        return SPORT_NEWS;
    }

    public List<New> getWORLD_NEWS() {
        return WORLD_NEWS;
    }

    /*
     * 国际新闻
     * */
    private List<New> WORLD_NEWS;

    public void setHOT_NEWS(List<New> HOT_NEWS) {
        this.HOT_NEWS = HOT_NEWS;
    }

    public void setENTERTAINMENT_NEWS(List<New> ENTERTAINMENT_NEWS) {
        this.ENTERTAINMENT_NEWS = ENTERTAINMENT_NEWS;
    }

    public void setTECH_NEWS(List<New> TECH_NEWS) {
        this.TECH_NEWS = TECH_NEWS;
    }

    public void setMILITARY(List<New> MILITARY) {
        this.MILITARY = MILITARY;
    }

    public void setSPORT_NEWS(List<New> SPORT_NEWS) {
        this.SPORT_NEWS = SPORT_NEWS;
    }

    public void setWORLD_NEWS(List<New> WORLD_NEWS) {
        this.WORLD_NEWS = WORLD_NEWS;
    }
}
