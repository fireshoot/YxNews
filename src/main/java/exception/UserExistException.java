package exception;

/**
 * @author yangxin
 * @time 2018/12/25  9:57
 */
public class UserExistException extends UserException {
    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
