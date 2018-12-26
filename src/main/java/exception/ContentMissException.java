package exception;

/**
 * @author yangxin
 * @time 2018/12/25  13:13
 */
public class ContentMissException extends NewException {
    public ContentMissException(String message) {
        super(message);
    }

    public ContentMissException(String message, Throwable cause) {
        super(message, cause);
    }
}
