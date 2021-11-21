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
import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
@WebServlet("/Educational/student/studentList")
public class StudentListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentListService studentListService = new StudentListServiceImpl();
        //获取参数
        String stuName = req.getParameter("stuName");
        String stuNo = req.getParameter("stuNo");
        String sex = req.getParameter("sex");
        //当前页
        String pageIndex = req.getParameter("pageIndex");
        int pageSize = 5;
        //没有传入，默认1，首页
        int index = pageIndex == null?1:Integer.parseInt(pageIndex);
        //获取总条数
        int total = studentListService.total(stuName,stuNo,sex);
        //总页数 获取总页数=总条数%每页显示的条数>0?总条数/每页显示条数+1:总条数/每页显示条数
        int pageNums = total%pageSize>0?total/pageSize+1:total/pageSize;
        //如果当前页大于总页数，取总页数
        index = index>pageNums?pageNums:index;
        //调用service获取列表
        List<Student> studentList = studentListService.getList(stuName,stuNo,sex,index,pageSize);
        req.setAttribute("studentList",studentList);
        req.setAttribute("stuName",stuName);
        req.setAttribute("stuNo",stuNo);
        req.setAttribute("sex",sex);
        req.setAttribute("pageIndex",index);
        req.setAttribute("pageSize",pageSize);
        req.setAttribute("pageNums",pageNums);
        req.setAttribute("total",total);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
