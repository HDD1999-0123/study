package com.hdd.dao.imp;

import com.hdd.bean.Courier;
import com.hdd.bean.User;
import com.hdd.dao.BaseCourierDao;
import com.hdd.dao.BaseUserDao;
import com.hdd.util.DruidUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourierDaoMysql implements BaseCourierDao {
    //控制台
    public static final String SQL_CONSOLE = "SELECT COUNT(ID) admin_size,COUNT(TO_DAYS(CREATETIME)=TO_DAYS(NOW()) OR NULL) admin_day FROM COURIER";
    public static final String SQL_FIND_LIMIT = "SELECT * FROM COURIER LIMIT ?,?";
    public static final String SQL_FIND_ALL = "SELECT * FROM COURIER";
    public static final String SQL_INSERT = "INSERT INTO COURIER (username,userphone,password,idcard,createtime) VALUES(?,?,?,?,now())";
    public static final String SQL_FIND_BY_PHONE = "SELECT * FROM COURIER WHERE USERPHONE=?";
    public static final String SQL_UPDATE = "UPDATE COURIER SET USERNAME=?,USERPHONE=?,PASSWORD=?,IDCARD=? WHERE ID=?";
    public static final String SQL_DELETE = "DELETE FROM COURIER WHERE ID=?";
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
                int courier_size = result.getInt("admin_size");
                int courier_day = result.getInt("admin_day");
                Map data1 = new HashMap();
                data1.put("courier_size",courier_size);
                data1.put("courier_day",courier_day);
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
    public List<Courier> findAll(boolean limit, int offset, int pageNumber) {
        ArrayList<Courier> data = new ArrayList<>();
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
                String idcard = result.getString("idcard");
                String password = result.getString("password");
                Integer count = result.getInt("count");
                Timestamp createTime = result.getTimestamp("createtime");
                Timestamp loginTime = result.getTimestamp("logintime");
                Courier courier = new Courier(id,username,userPhone,idcard,password,count,createTime,loginTime);
                data.add(courier);
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
    public boolean insert(Courier courier) {
        //1.    连接的获取
        Connection conn = DruidUtil.getConnection();
        //2.    预编译SQL语句
        PreparedStatement state = null;
        try {
            state = conn.prepareStatement(SQL_INSERT);
            //3.    填充参数
            state.setString(1,courier.getUsername());
            state.setString(2,courier.getUserphone());
            state.setString(3,courier.getPassword());
            state.setString(4,courier.getIdcard());
            //4.    执行SQL语句,并获取执行结果
            return state.executeUpdate()>0?true:false;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally {
            //5.    释放资源
            DruidUtil.close(conn,state,null);
        }
        return false;
    }

    @Override
    public Courier findByPhone(String userphone) {
        //1.    获取数据库的连接
        Connection conn = DruidUtil.getConnection();
        PreparedStatement state = null;
        ResultSet result = null;
        //2.    预编译SQL语句
        try {
            state = conn.prepareStatement(SQL_FIND_BY_PHONE);
            //3.    填充参数(可选)
            state.setString(1,userphone);
            //4.    执行SQL语句
            result = state.executeQuery();
            //5.    获取执行的结果
            if(result.next()){
                int id = result.getInt("id");
                String username = result.getString("username");
                String userPhone = result.getString("userphone");
                String idcard = result.getString("idcard");
                String password = result.getString("password");
                Integer count = result.getInt("count");
                Timestamp createtime = result.getTimestamp("createtime");
                Timestamp logintime = result.getTimestamp("logintime");
                Courier courier = new Courier(id,username,userphone,idcard,password,count,createtime,logintime);
                return courier;
            }
            //6.    资源的释放
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtil.close(conn,state,result);
        }
        return null;
    }

    @Override
    public boolean update(int id, Courier courier) {
        //1.    连接的获取
        Connection conn = DruidUtil.getConnection();
        PreparedStatement state = null;
        //2.    预编译SQL语句
        try {
            state = conn.prepareStatement(SQL_UPDATE);
            state.setString(1,courier.getUsername());
            state.setString(2,courier.getUserphone());
            state.setString(3,courier.getPassword());
            state.setString(4,courier.getIdcard());
            state.setInt(5,id);
            return state.executeUpdate()>0?true:false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtil.close(conn,state,null);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        //1.    连接的获取
        Connection conn = DruidUtil.getConnection();
        PreparedStatement state = null;
        //2.    预编译SQL语句
        try {
            state = conn.prepareStatement(SQL_DELETE);
            state.setInt(1,id);
            return state.executeUpdate()>0?true:false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtil.close(conn,state,null);
        }
        return false;
    }
}
