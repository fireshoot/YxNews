package service.impl;


import dao.RedisDao;
import dao.UserDao;
import dto.ResgisterState;
import entity.User;
import enums.UserRegisterEnums;
import exception.UserException;
import exception.UserExistException;
import exception.UserInsertException;
import exception.UserMisssException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author yangxin
 * @time 2018/12/25  9:20
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    //密码Md5加密的盐
    private final String salt="auogahbvafihvoonafio993";

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpSession session;

    @Autowired
    private RedisDao redisDao;

    /*
    * 优化：1.添加事务注解和事务的配置，当注册异常时回滚和正常时的提交。
    *       2.自定义异常类，出现相应的错误，抛出异常回滚。
    * */
    @Override
    @Transactional
    public ResgisterState register(User user)
            throws UserException,UserExistException,UserMisssException, UserInsertException {
        String password=user.getUserPassword();
        user.setUserPassword(getSalt(password));
        String redisKey="user:";
        try{
            User redisUser=redisDao.getUser(redisKey,user.getUserName());
            if(redisUser==null){
                String res=redisDao.setUser(redisKey,user);
                logger.info("############yangxin专用日志########### 注册功能模块的插入Redis数据返回值："+res);
                int insertCount=userDao.insertUser(user);
                if(insertCount<=0){
                    throw  new UserInsertException(UserRegisterEnums.FAIL.getStateInfo());
                }else{
                    return new ResgisterState(user.getUserId(),UserRegisterEnums.SUCCESS,user);
                }
            }else{//如果redis中已经存在，表示该用户名不能被注册
               throw new UserExistException(UserRegisterEnums.RedisEXIST.getStateInfo());
            }
        }catch (UserExistException existException) {
            return  new ResgisterState(user.getUserId(),UserRegisterEnums.RedisEXIST);
        }catch (UserMisssException e){
            throw e;
        }catch (UserInsertException e){
            logger.error(e.getMessage(),e);
            return new ResgisterState(user.getUserId(),UserRegisterEnums.FAIL);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            return  new ResgisterState(user.getUserId(),UserRegisterEnums.INNER_ERROR);
        }
    }

    @Override
    public User selectByName(String userName) {
        return userDao.queryByName(userName);
    }

    @Override
    public User login(String userName, String Password) {
        String password=getSalt(Password);
        String redisKey="userLogin:";
        User user=redisDao.getUser(redisKey,userName);
        if(user!=null){//user表示redis中存在。
            return user;
        }else{//表示redis中没有这个数据再数据库中查找
            User dbUser = userDao.queryById(userName, password);
            if(dbUser!=null){
                String result=redisDao.setUser(redisKey,dbUser);
                return dbUser;
            }
            return null;
        }
    }

    @Override
    public ResgisterState updateUser(User user) {
        User u=userDao.queryByOnlyId(user.getUserId());
        if(u==null){
            return new ResgisterState(user.getUserId(),UserRegisterEnums.NOTEXIST);
        }else{
            String pas=getSalt(user.getUserPassword());
            user.setUserPassword(pas);
            int updateCount=userDao.updateUser(user);
            if(updateCount<=0){
                return new ResgisterState(user.getUserId(),UserRegisterEnums.UPDATEFAIL);
            }else{
                return new ResgisterState(user.getUserId(),UserRegisterEnums.SUCCESS,user);
            }
        }
    }

    @Override
    public User selectByEmail(String email,String username) {
        return userDao.queryByOnlyEmail(email,username);
    }

    //加密
    private String getSalt(String userPassword){
        String md5=userPassword+'/'+salt;
        return DigestUtils.md5DigestAsHex(md5.getBytes());
    }

    public void ForceLogout(String UserName){
        User u = (User) session.getAttribute("user");
        try {
            session.removeAttribute("user");
            ServletContext application = session.getServletContext();
            @SuppressWarnings("unchecked")
            Map<Integer, Object> loginMap = (Map<Integer, Object>) application.getAttribute("loginMap");
            logger.info("############yangxin专用日志###########  强制注销功能模块的数据："+u.getUserId());
            loginMap.remove((int)u.getUserId());
            application.setAttribute("loginMap", loginMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("############yangxin专用日志###########  强制注销功能模块的出现异常");
        }
    }
}
