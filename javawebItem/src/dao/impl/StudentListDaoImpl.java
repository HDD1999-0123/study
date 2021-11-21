package dao.impl;

import bean.Student;
import dao.StudentListDao;
import utils.DruidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class StudentListDaoImpl implements StudentListDao {
    @Override
    public List<Student> getList(String stuName,String stuNo,String sex,Integer pageIndex,Integer pageSize) {
        List<Student> studentList = new ArrayList<>();
        List<Object> param = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from student where 1=1");
        if (stuName != null && stuName.length()>0){
            sql.append(" and stuname like ?");
            param.add("%"+stuName+"%");
        }
        if (stuNo != null && stuNo.length()>0){
            sql.append(" and stuNo like ?");
            param.add("%"+stuNo+"%");
        }
        if (sex != null && sex.length()>0){
            Integer sex1 = Integer.parseInt(sex);
            if (sex1!=-1){
                sql.append(" and sex = ?");
                param.add(sex1);
            }
        }
        //limit（i，n）：i代表数据的索引值，n代表查询出来的数量
        sql.append(" limit ?,?");
        param.add((pageIndex-1)*pageSize);
        param.add(pageSize);
        try {
            ResultSet query = DruidUtil.query(sql.toString(), param);
            if (query == null){
                return null;
            }
            while (query.next()){
                Student student = new Student();
                student.setStuId(query.getInt("stuid"));
                student.setStuNo(query.getString("stuno"));
                student.setStuName(query.getString("stuname"));
                student.setSex(query.getInt("sex"));
                student.setPhone(query.getString("phone"));
                student.setProfession(query.getString("profession"));
                student.setRegDate(query.getDate("regdate"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Integer total(String stuName, String stuNo, String sex) {
        List<Object> param = new ArrayList<>();
        int total = 0;
        StringBuffer sql = new StringBuffer("select count(1) from student where 1=1");
        if (stuName != null && stuName.length()>0){
            sql.append(" and stuname like ?");
            param.add("%"+stuName+"%");
        }
        if (stuNo != null && stuNo.length()>0){
            sql.append(" and stuNo like ?");
            param.add("%"+stuNo+"%");
        }
        if (sex != null && sex.length()>0){
            Integer sex1 = Integer.parseInt(sex);
            if (sex1!=-1){
                sql.append(" and sex = ?");
                param.add(sex1);
            }
        }
        try {
            ResultSet query = DruidUtil.query(sql.toString(), param);
            if (query == null){
                return null;
            }
            while (query.next()){
                total = query.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public int add(Student student) {
        List<Object> param = new ArrayList<>();
        int result = 0;
        String sql = "insert into student(stuno,stuname,gid,sex,email,phone,registered,address,politics,idNumber,profession,introduction,regdate)" +
                "value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        param.add(student.getStuNo());
        param.add(student.getStuName());
        param.add(student.getGid());
        param.add(student.getSex());
        param.add(student.getEmail());
        param.add(student.getPhone());
        param.add(student.getRegistered());
        param.add(student.getAddress());
        param.add(student.getPolitics());
        param.add(student.getIdNumber());
        param.add(student.getProfession());
        param.add(student.getIntroduction());
        param.add(student.getRegDate());
        try {
            result = DruidUtil.update(sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int stuid) {
        List<Object> param = new ArrayList<>();
        int result = 0;
        String sql = "delete from student where stuid = ?";
        param.add(stuid);
        try {
            result = DruidUtil.update(sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0;
    }

    @Override
    public Student getDetails(int stuid) {
        List<Object> param = new ArrayList<>();
        Student student = new Student();
        String sql = "select * from student where stuid = ?";
        param.add(stuid);
        try {
            ResultSet query = DruidUtil.query(sql, param);
            while (query.next()){
                student.setStuNo(query.getString("stuno"));
                student.setStuName(query.getString("stuname"));
                student.setGid(query.getInt("gid"));
                student.setSex(query.getInt("sex"));
                student.setEmail(query.getString("email"));
                student.setPhone(query.getString("phone"));
                student.setRegistered(query.getString("registered"));
                student.setAddress(query.getString("address"));
                student.setPolitics(query.getString("politics"));
                student.setIdNumber(query.getString("idnumber"));
                student.setProfession(query.getString("profession"));
                student.setIntroduction(query.getString("introduction"));
                student.setRegDate(query.getDate("regdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public int update(Student student) {
        List<Object> param = new ArrayList<>();
        int result = 0;
        String sql = "update student set stuno=?,stuname=?,gid=?,sex=?,email=?,phone=?,registered=?,address=?,politics=?,idNumber=?,profession=?,introduction=?,regdate=? where stuid=?";
        param.add(student.getStuNo());
        param.add(student.getStuName());
        param.add(student.getGid());
        param.add(student.getSex());
        param.add(student.getEmail());
        param.add(student.getPhone());
        param.add(student.getRegistered());
        param.add(student.getAddress());
        param.add(student.getPolitics());
        param.add(student.getIdNumber());
        param.add(student.getProfession());
        param.add(student.getIntroduction());
        param.add(student.getRegDate());
        param.add(student.getStuId());
        try {
            result = DruidUtil.update(sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean verify(String stuno) {
        List<Object> param = new ArrayList<>();
        int result = 0;
        String sql = "select count(1) from student where stuno=?";
        param.add(stuno);
        try {
            ResultSet query = DruidUtil.query(sql, param);
            while (query.next()){
                result = query.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result == 0;
    }
}
