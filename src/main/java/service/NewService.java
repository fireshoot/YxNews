package service;

import dto.InsertNewState;
import dto.NewDetail;
import dto.NewList;
import dto.NewsData;
import entity.New;
import entity.User;

import java.util.List;

/**
 * @author yangxin
 * @time 2018/12/25  10:57
 */
public interface NewService {

    /*
    * 插入新新闻
    * */
    InsertNewState insertNew(New n);

    /*
    * 获取主页的所有类型的新闻。
    * */
    NewList selectIndexNew();

    /*
    * 获取新闻的详情信息。新闻内容、作者信息
    * */
    NewDetail selectNew(long newId);

    /*
    * 作者查询自己发表的新闻列表
    * */
    List<New> selectNewsByUserId(long userId);

    /*
    * 管理员查看所有发表新闻
    * */
    List<NewsData> selectAllNews();

    /*
    * 删除指定新闻
    * 1.是用户本身删除自己的新闻：需要验证用户信息
    * 2.管理员删除不合格的新闻，验证用户是不是为管理员。
    * */
    InsertNewState deleteNew(long newId, User user);

    /*
    * 更新新闻内容
    * */
    InsertNewState updateNews(New n);


}
