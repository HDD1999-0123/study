package com.hdd.dao.impl;


import com.hdd.bean.Student;
import com.hdd.dao.StudentDao;
import com.hdd.util.DruidUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//接口名+Impl=当前类名
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getall() {
        List<Student> list=new ArrayList();
        ResultSet resultSet=null;
        try {
            resultSet = DruidUtil.query("select * from user",null);
            while (resultSet.next()){
                Student student = new Student();
                student.setStuid(resultSet.getInt("id"));
                student.setStuname(resultSet.getString("userName"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getInt("sex"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
