package demo;

import java.io.Serializable;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -7720536248415290709L;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Student() {
    }
}
