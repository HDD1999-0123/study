package com.hdd.servlet;

import com.hdd.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
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
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/false.html").forward(request,response);
        }
    }
}
