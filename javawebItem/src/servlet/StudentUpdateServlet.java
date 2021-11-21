package servlet;

import bean.Student;
import service.StudentListService;
import service.impl.StudentListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
@WebServlet(urlPatterns = "/Educational/student/update")
public class StudentUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentListService studentListService = new StudentListServiceImpl();
        Student student = new Student();
        //获取参数
        student.setStuId(Integer.parseInt(req.getParameter("stuId")));
        student.setStuNo(req.getParameter("stuNo"));
        student.setStuName(req.getParameter("stuName"));
        student.setGid(Integer.parseInt(req.getParameter("gid")));
        student.setSex(Integer.parseInt(req.getParameter("sex")));
        student.setEmail(req.getParameter("email"));
        student.setPhone(req.getParameter("phone"));
        student.setRegistered(req.getParameter("registered"));
        student.setAddress(req.getParameter("address"));
        student.setPolitics(req.getParameter("politics"));
        student.setIdNumber(req.getParameter("idNumber"));
        student.setProfession(req.getParameter("profession"));
        student.setIntroduction(req.getParameter("introduction"));
        student.setRegDate(new Date());
        //调用service
        int result = studentListService.update(student);
        if (result > 0){
            req.getRequestDispatcher("studentList").forward(req,resp);
        }
    }
}
