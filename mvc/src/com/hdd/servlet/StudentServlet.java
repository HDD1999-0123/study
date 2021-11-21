package com.hdd.servlet;


import com.hdd.bean.Student;
import com.hdd.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//C -controller 控制层
@WebServlet(urlPatterns = "/getstus")
public class StudentServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收请求参数
        //2.调取service层方法
        StudentServiceImpl studentService = new StudentServiceImpl();
        List<Student> getall = studentService.getall();
        //3.跳转页面
        //后台传递数据给前台
        req.setAttribute("stulist",getall);
        req.getRequestDispatcher("/show.jsp").forward(req,resp);

    }
}
