package entity;

import java.util.Date;

/**
 * @author yangxin
 * @time 2018/12/24  14:24
 */
public class New {
    private long newId;

    private long categoryId;

    private long userId;

    private String title;

    private String content;

    private Date createTime;

    private String keyWords;

    public New(long categoryId, long userId, String title, String content, String keyWords) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.keyWords = keyWords;
    }

    public New() {
    }

    @Override
    public String toString() {
        return "New{" +
                "newId=" + newId +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                /*", content='" + content + '\'' +*/
                ", createTime=" + createTime +
                ", keyWords='" + keyWords + '\'' +
                '}';
    }

    public long getNewId() {
        return newId;
    }

    public void setNewId(long newId) {
        this.newId = newId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String key_words) {
        this.keyWords = key_words;
    }
}
