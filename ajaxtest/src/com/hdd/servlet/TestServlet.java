package com.hdd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/testuname")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //1.接收参数
        String username = req.getParameter("username");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        if("admin".equals(username)){
            writer.println("账户已被注册");
        }else{
            writer.println("账户可用");
        }
    }
}
