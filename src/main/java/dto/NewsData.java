package dto;

import entity.New;

/**
 * @author yangxin
 * @time 2018/12/27  15:30
 */
public class NewsData {

    private New aNew;

    private String typeName;

    private String userName;


    public NewsData() {
    }

    public NewsData(New aNew, String typeName, String userName) {
        this.aNew = aNew;
        this.typeName = typeName;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "NewsData{" +
                "aNew=" + aNew +
                ", typeName='" + typeName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public New getaNew() {
        return aNew;
    }

    public void setaNew(New aNew) {
        this.aNew = aNew;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
