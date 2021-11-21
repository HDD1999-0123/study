package com.hdd.dao.impl;

import com.hdd.dao.BaseAdminDao;
import com.hdd.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class AdminDaoMysql implements BaseAdminDao {
    private static final String SQL_UPDATE_LOGIN_TIME = "update eadmin set logintime=?,loginip=? where username =?";
    private static final String SQL_LOGIN = "select id from eadmin where username=? and password = ?";

    @Override
    public void updateLoginTime(String username, Date date, String ip) {
        //1.获取连接
        Connection connection = DruidUtil.getConnection();
        //2.预编译sql
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_LOGIN_TIME);
            //3.填充参数
            preparedStatement.setDate(1,new java.sql.Date(date.getTime()));
            preparedStatement.setString(2,ip);
            preparedStatement.setString(3,username);
            //4.执行sql
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5.释放资源
            DruidUtil.close(connection,preparedStatement,null);
        }
    }

    @Override
    public boolean login(String username, String password) {
        //1.获取连接
        Connection connection = DruidUtil.getConnection();
        //2.预编译sql
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_LOGIN);
            //3.填充参数
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            //4.执行sql
            resultSet = preparedStatement.executeQuery();
            //5.根据查询结果返回
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            DruidUtil.close(connection,preparedStatement,null);
        }
        return false;
    }
}
