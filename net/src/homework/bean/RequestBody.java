package homework.bean;

import java.io.Serializable;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class RequestBody implements Serializable {
    private static final long serialVersionUID = -8042492681457318402L;
    private User user;
    private String cmd;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
}
