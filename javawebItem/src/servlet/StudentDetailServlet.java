package servlet;

import bean.Student;
import dao.StudentListDao;
import service.StudentListService;
import service.impl.StudentListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
@WebServlet(urlPatterns = "/Educational/student/detail")
public class StudentDetailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentListService studentListService = new StudentListServiceImpl();
        //接收参数
        int stuid = Integer.parseInt(req.getParameter("stuid"));
        //调用service
        Student student = studentListService.getDetails(stuid);
        student.setStuId(stuid);
        req.setAttribute("student",student);
        //跳转
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
