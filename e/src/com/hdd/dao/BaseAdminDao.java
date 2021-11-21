package com.hdd.dao;

import java.util.Date;

/**
 * 用于定义eadmin表格的操作规范
 */
public interface BaseAdminDao {
    /**
     * 根据用户名，更新登陆时间和登录ip
     * @param username
     */
    void updateLoginTime(String username, Date date,String ip);

    /**
     * 管理员更具账号密码登录
     * @param username 账号
     * @param password 密码
     * @return 登陆结果
     */
    boolean login(String username,String password);
}
