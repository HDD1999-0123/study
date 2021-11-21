package com.hdd.service.impl;



import com.hdd.bean.Student;
import com.hdd.dao.StudentDao;
import com.hdd.dao.impl.StudentDaoImpl;
import com.hdd.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao=new StudentDaoImpl();

    @Override
    public List<Student> getall() {
        return studentDao.getall();
    }
}
