package utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=utf-8");
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null){
            response.getWriter().println("<script>alert('您还未登录！');</script>");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
