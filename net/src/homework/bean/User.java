package homework.bean;

import java.io.Serializable;

/**
 * @version
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class User implements Serializable {
    private static final long serialVersionUID = -4218269056038390739L;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
