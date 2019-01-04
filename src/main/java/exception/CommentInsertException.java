package exception;

/**
 * @author yangxin
 * @time 2019/1/4  12:51
 */
public class CommentInsertException extends CommentException {
    public CommentInsertException(String message) {
        super(message);
    }

    public CommentInsertException(String message, Throwable cause) {
        super(message, cause);
    }
}
