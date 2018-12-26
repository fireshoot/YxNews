package dto;

import entity.New;
import enums.InsertNewEnums;

/**
 * @author yangxin
 * @time 2018/12/25  11:11
 */
public class InsertNewState {
    private long newId;

    private int state;

    private String stateInfo;

    private New aNew;

    public InsertNewState(long newId, InsertNewEnums insertNewEnums) {
        this.newId = newId;
        this.state = insertNewEnums.getState();
        this.stateInfo = insertNewEnums.getStateinfo();
    }

    public InsertNewState(long newId, InsertNewEnums insertNewEnums, New aNew) {
        this.newId = newId;
        this.state = insertNewEnums.getState();
        this.stateInfo = insertNewEnums.getStateinfo();
        this.aNew = aNew;
    }

    public long getNewId() {
        return newId;
    }

    public void setNewId(long newId) {
        this.newId = newId;
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

    public New getaNew() {
        return aNew;
    }

    public void setaNew(New aNew) {
        this.aNew = aNew;
    }

    @Override
    public String toString() {
        return "InsertNewState{" +
                "newId=" + newId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", aNew=" + aNew +
                '}';
    }
}
