package com.hdd.fiter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
@WebFilter(filterName = "*.do")
public class CharsetFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        request.setCharacterEncoding("utf-8");
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        filterChain.doFilter(request,response);
    }
}
