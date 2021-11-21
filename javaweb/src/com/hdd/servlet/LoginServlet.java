package com.hdd.servlet;


import com.hdd.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        HttpSession session = request.getSession();
        session.setAttribute("userName",userName);
        boolean result = userDao.login(userName,pwd);
        if (result){
            response.sendRedirect("/success.jsp");
        }else {
            request.getRequestDispatcher("/login.html").forward(request,response);
        }
    }
}
