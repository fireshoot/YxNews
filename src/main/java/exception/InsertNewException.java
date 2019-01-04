package exception;

/**
 * @author yangxin
 * @time 2019/1/4  11:52
 */
public class InsertNewException extends NewException {
    public InsertNewException(String message) {
        super(message);
    }

    public InsertNewException(String message, Throwable cause) {
        super(message, cause);
    }
}
