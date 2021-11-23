package com.hdd.wx.filter;


import com.hdd.bean.User;
import com.hdd.util.UserUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/index.html"})
public class UserFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)req).getSession();
        User wxUser = UserUtil.getWxUser(session);
        if(wxUser != null) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse)resp).sendRedirect("login.html");
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
