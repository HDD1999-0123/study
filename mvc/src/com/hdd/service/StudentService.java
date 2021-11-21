package com.hdd.service;


import com.hdd.bean.Student;

import java.util.List;

// bean类名+Service =当前类名
//service层主要定义业务逻辑，现阶段主要实现调取dao层
public interface StudentService {
    //查询全部
    public List<Student> getall();
}
