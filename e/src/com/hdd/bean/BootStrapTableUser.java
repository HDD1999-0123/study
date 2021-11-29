package com.hdd.bean;

import java.sql.Timestamp;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class BootStrapTableUser {
    private int id;
    private String userName;
    private String userPhone;
    private String password;
    private String idcard;

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    private String createTime;
    private String loginTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public BootStrapTableUser(int id, String userName, String userPhone, String password, String createTime, String loginTime) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.password = password;
        this.createTime = createTime;
        this.loginTime = loginTime;
    }
}
