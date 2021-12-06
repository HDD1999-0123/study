package com.hdd.bean;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class Courier {
    private Integer id;
    private String username;
    private String userphone;
    private String idcard;
    private String password;
    private Integer count;
    private Timestamp createtime;
    private Timestamp logintime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getLogintime() {
        return logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    public Courier(Integer id, String username, String userphone, String idcard, String password, Integer count, Timestamp createtime, Timestamp logintime) {
        this.id = id;
        this.username = username;
        this.userphone = userphone;
        this.idcard = idcard;
        this.password = password;
        this.count = count;
        this.createtime = createtime;
        this.logintime = logintime;
    }

    public Courier(String username, String userphone, String idcard, String password) {
        this.username = username;
        this.userphone = userphone;
        this.idcard = idcard;
        this.password = password;
    }

    public Courier() {
    }
}
