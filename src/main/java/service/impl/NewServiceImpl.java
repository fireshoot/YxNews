package service.impl;

import dao.NewDao;
import dao.UserDao;
import dto.InsertNewState;
import dto.NewDetail;
import dto.NewList;
import dto.NewsData;
import entity.New;
import entity.User;
import enums.InsertNewEnums;
import exception.ContentMissException;
import exception.NewException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.NewService;

import java.util.List;

/**
 * @author yangxin
 * @time 2018/12/25  13:04
 */
@Service
public class NewServiceImpl implements NewService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NewDao newDao;

    @Autowired
    private UserDao userDao;

    @Override
    public InsertNewState insertNew(New n)
        throws NewException, ContentMissException {
        if(n==null){
            throw new ContentMissException("插入数据不完整！");
        }else{
            New news=newDao.queryByNewName(n.getTitle());
            if(news!=null){
                return new InsertNewState(n.getNewId(), InsertNewEnums.EXIST);
            }else{
                int countInsert=newDao.insertNew(n);
                if(countInsert<=0){
                    return new InsertNewState(n.getNewId(), InsertNewEnums.FAIL);
                }else{
                    return new InsertNewState(n.getNewId(),InsertNewEnums.SUCCESS,n);
                }
            }

        }
    }

    @Override
    public NewList selectIndexNew() {
        List<New> hotnew=newDao.queryByCategoryId(1);
        List<New> entertail=newDao.queryByCategoryId(2);
        List<New> tech=newDao.queryByCategoryId(3);
        List<New> military=newDao.queryByCategoryId(4);
        List<New> sport=newDao.queryByCategoryId(5);
        List<New> world=newDao.queryByCategoryId(6);
        NewList newList=new NewList();
        newList.setHOT_NEWS(hotnew);
        newList.setENTERTAINMENT_NEWS(entertail);
        newList.setSPORT_NEWS(sport);
        newList.setTECH_NEWS(tech);
        newList.setMILITARY(military);
        newList.setWORLD_NEWS(world);
        return newList;
    }

    @Override
    public NewDetail selectNew(long newId) {
        New news=newDao.queryByNewId(newId);
        NewDetail detail=new NewDetail();
        if(news!=null){
            User user=userDao.queryByOnlyId(news.getUserId());
            detail.setSuccess(true);
            detail.setaNew(news);
            detail.setUser(user);
        }else{
            detail.setSuccess(false);
        }
        return detail;
    }

    @Override
    public List<New> selectNewsByUserId(long userId) {
        return newDao.queryByUserId(userId);
    }

    @Override
    public List<NewsData> selectAllNews() {
        return newDao.queryAllNews();
    }


    /*
     * 删除指定新闻
     * 1.是用户本身删除自己的新闻：需要验证用户信息
     * 2.管理员删除不合格的新闻，验证用户是不是为管理员。
     * */
    @Override
    public InsertNewState deleteNew(long newId , User user) {
        New n=newDao.queryByNewId(newId);
        if(n.getUserId()==user.getUserId()||user.getUserType()==2){
            int countdelete=newDao.deleteNew(newId);
            if(countdelete<=0){
                return new InsertNewState(newId,InsertNewEnums.FAIL);
            }else{
                return new InsertNewState(newId,InsertNewEnums.SUCCESS,n);
            }
        }else{
            return new InsertNewState(newId,InsertNewEnums.UNOPERATION);
        }
    }

    @Override
    public InsertNewState updateNews(New n) {
        New aNew=newDao.queryByNewId(n.getNewId());
        if(aNew==null){
            return new InsertNewState(n.getNewId(),InsertNewEnums.NOTEXIST);
        }else{
            int countUpdate=newDao.updateNew(n);
            if(countUpdate<=0){
                return new InsertNewState(n.getNewId(),InsertNewEnums.FAIL);
            }else{
                return new InsertNewState(n.getNewId(),InsertNewEnums.SUCCESS,n);
            }
        }
    }
}
