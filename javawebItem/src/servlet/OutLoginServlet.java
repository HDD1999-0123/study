package servlet;

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
@WebServlet(urlPatterns = "/outlogin")
public class OutLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁session
        req.getSession().invalidate();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("<script>alert('已退出');top.location.href='login.jsp'</script>");
    }
}
