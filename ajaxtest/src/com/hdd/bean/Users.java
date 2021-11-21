package com.hdd.bean;

//实体类
public class Users {
    private Integer uid;
    private String username;
    private String password;
    private Double money;

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }

    public Users() {
    }

    public Users(Integer uid, String username, String password, Double money) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
