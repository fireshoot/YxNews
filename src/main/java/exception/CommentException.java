package exception;

/**
 * @author yangxin
 * @time 2019/1/4  12:50
 */
public class CommentException extends RuntimeException {
    public CommentException(String message) {
        super(message);
    }

    public CommentException(String message, Throwable cause) {
        super(message, cause);
    }
}
