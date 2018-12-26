package exception;

/**
 * @author yangxin
 * @time 2018/12/25  9:56
 */
public class UserMisssException extends UserException {
    public UserMisssException(String message) {
        super(message);
    }

    public UserMisssException(String message, Throwable cause) {
        super(message, cause);
    }
}
