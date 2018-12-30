package exception;

/**
 * @author yangxin
 * @time 2018/12/30  16:21
 */
public class UserInsertException extends UserException {
    public UserInsertException(String message) {
        super(message);
    }

    public UserInsertException(String message, Throwable cause) {
        super(message, cause);
    }
}
