package servlet;

import bean.Menu;
import bean.Role;
import bean.Users;
import service.MenuService;
import service.RoleService;
import service.UserService;
import service.impl.MenuServiceImpl;
import service.impl.RoleServiceImpl;
import service.impl.UserServiceImpl;
import utils.PageUtils;

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
@WebServlet(urlPatterns = "/power/role/roles")
public class RoleSevlet extends HttpServlet {
    private RoleService roleService = new RoleServiceImpl();
    private MenuService menuService = new MenuServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("select".equals(method)){
            select(req,resp);
        }else if ("selectmenus".equals(method)){
            selectmenus(req,resp);
        }else if ("insert".equals(method)){
            insert(req,resp);
        }else if ("delete".equals(method)){
            delete(req,resp);
        }else if ("edit".equals(method)){
            edit(req,resp);
        }else if ("update".equals(method)){
            update(req,resp);
        }
    }
    //编辑，更新
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleId = req.getParameter("roleId");
        String roleName = req.getParameter("roleName");
        String state = req.getParameter("state");
        //得到一个字符串的数组
        String[] menuids = req.getParameterValues("menuid");
        Integer i = roleService.update(roleId, roleName, state, menuids);
        if (i>0){
            resp.sendRedirect("/power/role/roles?method=select");
        }
    }
    //编辑，显示详情
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleId = req.getParameter("roleId");
        Role role = roleService.edit(roleId);
        role.setRoleId(Integer.parseInt(roleId));
        req.setAttribute("role",role);
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
    //删除角色
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleId = req.getParameter("roleId");
        int i = roleService.delete(roleId);
        if (i>0){
            resp.sendRedirect("/power/role/roles?method=select");
        }
    }
    //添加角色
    protected void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName = req.getParameter("roleName");
        String state = req.getParameter("state");
        //得到一个字符串的数组
        String[] menuids = req.getParameterValues("menuid");
        int i = roleService.insertRole(roleName, state, menuids);
        if (i>0){
            resp.sendRedirect("/power/role/roles?method=select");
        }else {
            resp.sendRedirect("/power/role/roles?method=selectmenus");
        }
    }
    //查询菜单列表
    protected void selectmenus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收参数
        //2.调取sevice方法
        List<Menu> menuList = menuService.getMenuList();
        req.setAttribute("menuList",menuList);
        req.getRequestDispatcher("add.jsp").forward(req,resp);
    }
    //查询数据（分页）
    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收参数（分页参数+模糊查参数）
        String index = req.getParameter("index");
        int pageIndex = (index==null||index.length()==0)?1:Integer.parseInt(index);
        //1.调取sevice方法（查询数据列表，查询总条数）
        PageUtils pageUtils = new PageUtils();
        List<Role> roleList = roleService.getRoleList(pageIndex,pageUtils.getPageSize());
        int total = roleService.total();
        pageUtils.setTotal(total);
        pageUtils.setDataList(roleList);
        pageUtils.setPageIndex(pageIndex);
        //存值条页面
        req.setAttribute("pi",pageUtils);
        req.getRequestDispatcher("list.jsp").forward(req,resp);

    }
}
