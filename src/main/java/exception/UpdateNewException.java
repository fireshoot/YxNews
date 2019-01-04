package exception;

/**
 * @author yangxin
 * @time 2019/1/4  12:18
 */
public class UpdateNewException extends NewException{
    public UpdateNewException(String message) {
        super(message);
    }

    public UpdateNewException(String message, Throwable cause) {
        super(message, cause);
    }
}
