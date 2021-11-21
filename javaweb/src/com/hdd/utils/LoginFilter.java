package com.hdd.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName:
 * @Descripton: 过滤器
 * @author: hedd
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //设置字符集
        request.setCharacterEncoding("utf-8");
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession();
        Object username = session.getAttribute("userName");
        //未登录不能直接访问success
        if (requestURI.endsWith("success.jsp")&&username==null){
            response.sendRedirect("login.html");
        }
        //调取下一个过滤器，或者调取servlet
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
