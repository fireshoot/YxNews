package dto;

/**
 * @author yangxin
 * @time 2018/12/26  11:34
 */
public class NewsResult<T> {
    private boolean success;

    private T data;

    private String errMes;

    public NewsResult(boolean success, String errMes) {
        this.success = success;
        this.errMes = errMes;
    }

    public NewsResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrMes(String errMes) {
        this.errMes = errMes;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getErrMes() {
        return errMes;
    }

    @Override
    public String toString() {
        return "NewsResult{" +
                "success=" + success +
                ", data=" + data +
                ", errMes='" + errMes + '\'' +
                '}';
    }
}
