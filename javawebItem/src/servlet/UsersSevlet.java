package servlet;

import bean.Users;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.PageUtils;

import javax.net.ssl.HttpsURLConnection;
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
@WebServlet(urlPatterns = "/power/user/users")
public class UsersSevlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("select".equals(method)){
            select(req,resp);
        }
    }
    //查询数据（分页）
    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收参数（分页参数+模糊查参数）
        String index = req.getParameter("index");
        int pageIndex = (index==null||index.length()==0)?1:Integer.parseInt(index);
        //1.调取sevice方法（查询数据列表，查询总条数）
        PageUtils pageUtils = new PageUtils();
        List<Users> usersList = userService.getUsersList(pageIndex,pageUtils.getPageSize());
        int total = userService.total();
        pageUtils.setTotal(total);
        pageUtils.setDataList(usersList);
        pageUtils.setPageIndex(pageIndex);
        //存值条页面
        req.setAttribute("pi",pageUtils);
        req.getRequestDispatcher("list.jsp").forward(req,resp);

    }
}
