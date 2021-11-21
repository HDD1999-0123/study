package dao;

import bean.Student;

import java.util.List;

public interface StudentListDao {
    List<Student> getList(String stuName,String stuNo,String sex,Integer pageIndex,Integer pageSize);

    Integer total(String stuName,String stuNo,String sex);

    int add(Student student);

    boolean delete(int stuid);

    Student getDetails(int stuid);

    int update(Student student);

    boolean verify(String stuno);
}
