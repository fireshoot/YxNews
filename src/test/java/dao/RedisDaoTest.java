package dao;

import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author yangxin
 * @time 2018/12/30  10:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉Junit Spring配置文件
@ContextConfiguration({"classpath:spring/springDao-config.xml"})
public class RedisDaoTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisDao redisDao;

    @Test
    public void getUser() {
        String redisKey="user:";
        System.out.println(""+redisDao.getUser(redisKey,"yangxin123"));
    }

    @Test
    public void setUser() {
        String redisKey="user:";
        User user=new User(0,"yangxin123","123456a","122@qq.com",18);
        logger.info(redisDao.setUser(redisKey,user));
    }
}