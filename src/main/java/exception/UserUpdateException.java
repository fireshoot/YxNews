package exception;

/**
 * @author yangxin
 * @time 2019/1/4  11:36
 */
public class UserUpdateException  extends  UserException{
    public UserUpdateException(String message) {
        super(message);
    }

    public UserUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
