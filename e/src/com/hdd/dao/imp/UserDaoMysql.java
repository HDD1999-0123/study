package com.hdd.dao.imp;

import com.hdd.bean.Express;
import com.hdd.bean.User;
import com.hdd.dao.BaseUserDao;
import com.hdd.util.DruidUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoMysql implements BaseUserDao {
    //控制台
    public static final String SQL_CONSOLE = "SELECT COUNT(ID) admin_size,COUNT(TO_DAYS(CREATETIME)=TO_DAYS(NOW()) OR NULL) admin_day FROM USER";
    public static final String SQL_FIND_LIMIT = "SELECT * FROM USER LIMIT ?,?";
    public static final String SQL_FIND_ALL = "SELECT * FROM USER";

    @Override
    public List<Map<String, Integer>> console() {
        ArrayList<Map<String,Integer>> data = new ArrayList<>();
        //1.    获取数据库的连接
        Connection conn = DruidUtil.getConnection();
        PreparedStatement state = null;
        ResultSet result = null;
        //2.    预编译SQL语句
        try {
            state = conn.prepareStatement(SQL_CONSOLE);
            //3.    填充参数(可选)
            //4.    执行SQL语句
            result = state.executeQuery();
            //5.    获取执行的结果
            if(result.next()){
                int admin_size = result.getInt("admin_size");
                int admin_day = result.getInt("admin_day");
                Map data1 = new HashMap();
                data1.put("admin_size",admin_size);
                data1.put("admin_day",admin_day);
                data.add(data1);
            }
            //6.    资源的释放
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtil.close(conn,state,result);
        }
        return data;
    }

    @Override
    public List<User> findAll(boolean limit, int offset, int pageNumber) {
        ArrayList<User> data = new ArrayList<>();
        //1.    获取数据库的连接
        Connection conn = DruidUtil.getConnection();
        PreparedStatement state = null;
        ResultSet result = null;
        //2.    预编译SQL语句
        try {
            if(limit) {
                state = conn.prepareStatement(SQL_FIND_LIMIT);
                //3.    填充参数(可选)
                state.setInt(1,offset);
                state.setInt(2,pageNumber);
            }else {
                state = conn.prepareStatement(SQL_FIND_ALL);
            }

            //4.    执行SQL语句
            result = state.executeQuery();
            //5.    获取执行的结果
            while(result.next()){
                int id = result.getInt("id");
                String username = result.getString("username");
                String userPhone = result.getString("userphone");
                String password = result.getString("userpwd");
                Timestamp createTime = result.getTimestamp("createtime");
                Timestamp loginTime = result.getTimestamp("logintime");
                User user = new User(id,username,userPhone,password,createTime,loginTime);
                data.add(user);
            }
            //6.    资源的释放
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtil.close(conn,state,result);
        }
        return data;
    }
}
