package exception;

/**
 * @author yangxin
 * @time 2018/12/25  13:11
 */
public class NewException extends RuntimeException {
    public NewException(String message) {
        super(message);
    }

    public NewException(String message, Throwable cause) {
        super(message, cause);
    }
}
