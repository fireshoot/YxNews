package dao;

import dto.NewsData;
import entity.New;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangxin
 * @time 2018/12/24  14:45
 */
public interface NewDao {

    /*
    * 插入新闻
    * */
    int insertNew(New news);

    /*
    * 根据新闻id查询新闻
    * */
    New queryByNewId(@Param("newId") long newId);

    /*
     * 根据新闻name查询新闻
     * */
    New queryByNewName(@Param("title") String title);

    /*
    * 根据类别id获取新闻列表
    * */
    List<New> queryByCategoryId(@Param("categoryId") long categoryId);

    /*
    * 根据作者Id获取作者所写的新闻列表
    * */
    List<New> queryByUserId(@Param("userId") long userId);

    /*
     * 后台管理员查看所有发表的新闻，并对其操作
     * */
    List<NewsData> queryAllNews();

    /*
    * 删除指定Id的新闻条目
    * */
    int deleteNew(@Param("newId")long newId);

    /*
    * 更新新闻数据
    * */
    int updateNew(New news);

}
