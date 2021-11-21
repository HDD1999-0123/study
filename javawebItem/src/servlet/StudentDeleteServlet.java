package servlet;

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
@WebServlet(urlPatterns = "/Educational/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentListService studentListService = new StudentListServiceImpl();
        //接收参数
        int stuid = Integer.parseInt(req.getParameter("stuid"));
        //调用service
        boolean result = studentListService.delete(stuid);
        //跳转页面
        if (result){
            req.getRequestDispatcher("studentList").forward(req,resp);
        }
    }
}
