package service.impl;

import bean.Student;
import dao.StudentListDao;
import dao.impl.StudentListDaoImpl;
import service.StudentListService;

import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class StudentListServiceImpl implements StudentListService {
    StudentListDao studentListDao = new StudentListDaoImpl();
    @Override
    public List<Student> getList(String stuName,String stuNo,String sex,Integer pageIndex,Integer pageSize) {
        return studentListDao.getList(stuName,stuNo,sex,pageIndex,pageSize);
    }

    @Override
    public Integer total(String stuName, String stuNo, String sex) {
        return studentListDao.total(stuName,stuNo,sex);
    }

    @Override
    public int add(Student student) {
        return studentListDao.add(student);
    }

    @Override
    public boolean delete(int stuid) {
        return studentListDao.delete(stuid);
    }

    @Override
    public Student getDetails(int stuid) {
        return studentListDao.getDetails(stuid);
    }

    @Override
    public int update(Student student) {
        return studentListDao.update(student);
    }

    @Override
    public boolean verify(String stuno) {
        return studentListDao.verify(stuno);
    }
}
