package service.impl;


import dao.UserDao;
import dto.ResgisterState;
import entity.User;
import enums.UserRegisterEnums;
import exception.UserException;
import exception.UserExistException;
import exception.UserMisssException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import service.UserService;

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

    @Override
    public ResgisterState register(User user)
            throws UserException,UserExistException,UserMisssException{
        String password=user.getUserPassword();
        user.setUserPassword(getSalt(password));
        try{
            User u=userDao.queryByName(user.getUserName());
            if(u==null){
                int insertCount=userDao.insertUser(user);
                if(insertCount<=0){
                    return new ResgisterState(user.getUserId(),UserRegisterEnums.FAIL);
                }else{
                    return new ResgisterState(user.getUserId(),UserRegisterEnums.SUCCESS,user);
                }
            }else{
                return new ResgisterState(user.getUserId(),UserRegisterEnums.EXIST);
            }
        }catch (UserExistException existException) {
            throw existException;
        }catch (UserMisssException e){
            throw e;
        }catch (Exception e){
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
        System.out.println("password:"+password);
        return userDao.queryById(userName,password);
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

    //加密
    private String getSalt(String userPassword){
        String md5=userPassword+'/'+salt;
        return DigestUtils.md5DigestAsHex(md5.getBytes());
    }
}
