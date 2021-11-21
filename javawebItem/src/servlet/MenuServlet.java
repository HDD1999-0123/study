package servlet;

import bean.Menu;
import service.MenuService;
import service.impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
@WebServlet(urlPatterns = "/power/menu/menus")
public class MenuServlet extends HttpServlet {
    MenuService menuService = new MenuServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("select".equals(method)){
            select(req,resp);
        }
    }
    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Menu> menuList = menuService.getList();
        req.setAttribute("menuList",menuList);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
