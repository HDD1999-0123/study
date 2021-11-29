package com.hdd.dao.imp;


import com.hdd.dao.BaseAdminDao;
import com.hdd.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AdminDaoMysql implements BaseAdminDao {
    //更新用户登录时间和ip
    private static final String SQL_UPDATE_LOGIN_TIME = "UPDATE EADMIN SET LOGINTIME=?,LOGINIP=? WHERE USERNAME=?";
    //登录
    private static final String SQL_LOGIN = "SELECT ID FROM EADMIN WHERE USERNAME=? AND PASSWORD=?";
    //控制台
    public static final String SQL_CONSOLE = "SELECT COUNT(ID) admin_size,COUNT(TO_DAYS(CREATETIME)=TO_DAYS(NOW()) OR NULL) admin_day FROM EADMIN";
    /**
     * 根据用户名，更新登陆时间和登录ip
     *
     * @param username
     * @param date
     * @param ip
     */
    @Override
    public void updateLoginTime(String username, Date date, String ip) {
        //1.    获取连接
        Connection conn = DruidUtil.getConnection();
        PreparedStatement state = null;
        //2.    预编译SQL语句
        try {
            state = conn.prepareStatement(SQL_UPDATE_LOGIN_TIME);
            //3.    填充参数
            state.setDate(1,new java.sql.Date(date.getTime()));
            state.setString(2,ip);
            state.setString(3,username);
            //4.    执行
            state.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //5.    释放资源
            DruidUtil.close(conn,state,null);
        }
    }

    /**
     * 管理员根据账号密码登陆
     *
     * @param username 账号
     * @param password 密码
     * @return 登陆的结果， true表示登陆成功
     */
    @Override
    public boolean login(String username, String password) {
        //1.    获取连接
        Connection conn = DruidUtil.getConnection();
        PreparedStatement state = null;
        ResultSet rs = null;
        //2.    预编译SQL语句
        try {
            state = conn.prepareStatement(SQL_LOGIN);
            //3.    填充参数
            state.setString(1,username);
            state.setString(2,password);
            //4.    执行并获取结果
            rs = state.executeQuery();
            //5.    根据查询结果，返回
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6.    释放资源
            DruidUtil.close(conn,state,rs);
        }
        return false;
    }
}
