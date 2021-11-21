package homework.bean;

import java.io.Serializable;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class ResponseBody implements Serializable {
    private static final long serialVersionUID = 3297048282491408044L;

    private int result;
    private boolean ok;
    private String message;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
