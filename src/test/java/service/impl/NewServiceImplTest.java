package service.impl;

import entity.New;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.NewService;

import static org.junit.Assert.*;

/**
 * @author yangxin
 * @time 2018/12/25  14:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/springDao-config.xml",
                "classpath:spring/springService-config.xml"})
public class NewServiceImplTest {

    @Autowired
    private NewService newService;

    @Test
    public void insertNew() {
        New news=new New(3,1010,"奥特曼","2834ujdasndlfh","科技");
        System.out.println(":"+newService.insertNew(news));
    }

    @Test
    public void selectIndexNew() {
        System.out.println("List:"+newService.selectIndexNew());
    }

    @Test
    public void selectNew() {
        int id=4;
        System.out.println(":"+newService.selectNew(id));
    }

    @Test
    public void selectNewsByUserId() {
        System.out.println(":"+newService.selectNewsByUserId(1010));
    }

    @Test
    public void selectAllNews() {
        System.out.println(":"+newService.selectAllNews());
    }

    @Test
    public void deleteNew() {
        int id=5;
        User user=new User(0,"dddd","dsaf","dsaf",118);
        user.setUserId(1010);
        System.out.println(":"+newService.deleteNew(id,user));
    }

    @Test
    public void updateNews() {
        New news=new New(3,1010,"奥特曼","2834ujdasndlfh","科技");
        news.setNewId(2);
        System.out.println(":"+newService.updateNews(news));
    }
}