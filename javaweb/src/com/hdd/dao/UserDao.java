package com.hdd.dao;

import com.hdd.utils.DruidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class UserDao {


    public boolean login(String userName, String pwd) {
        String sql = "select count(1) as countNum from user where userName = ? and pwd = ?";
        List<Object> list = new ArrayList<>();
        int result = 0;
        list.add(userName);
        list.add(pwd);
        try {
            ResultSet query = DruidUtil.query(sql, list);
            while (query.next()){
                result = query.getInt("countNum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0;
    }
}
