package exception;

/**
 * @author yangxin
 * @time 2018/12/25  9:43
 */
public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
