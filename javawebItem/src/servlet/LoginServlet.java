package servlet;

import bean.Users;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = new Users();
        LoginService loginService = new LoginServiceImpl();
        //1.获取表单数据
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        users.setLoginName(loginName);
        users.setPassWord(password);
        //2.编写服务层代码，处理登录数据
        Users result = loginService.login(users);
        if (result != null){
            //将登录名存入session
            req.getSession().setAttribute("loginUser",result);
            //跳转到首页
            resp.sendRedirect("/index.jsp");
        }else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<script>location.href='login.jsp';alert('用户名或密码有误，登录失败！')</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
