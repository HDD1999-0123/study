package com.hdd.dao;



import com.hdd.bean.Student;

import java.util.List;

//实体类名+Dao=当前类名
public interface StudentDao {

    //定义操作数据库的方法
    public List<Student> getall();
}
