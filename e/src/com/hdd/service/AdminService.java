package com.hdd.service;



import com.hdd.dao.BaseAdminDao;
import com.hdd.dao.imp.AdminDaoMysql;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class AdminService {

    private static BaseAdminDao dao = new AdminDaoMysql();

    /**
     * 更新登陆时间与ip
     * @param username
     * @param date
     * @param ip
     */
    public static void updateLoginTimeAndIP(String username, Date date, String ip){
        dao.updateLoginTime(username,date,ip);
    }

    /**
     * 登陆
     * @param username
     * @param password
     * @return true表示成功，false表示登陆失败
     */
    public static boolean login(String username,String password){
        return dao.login(username,password);
    }

}
