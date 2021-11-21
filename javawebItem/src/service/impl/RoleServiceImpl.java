package service.impl;

import bean.Menu;
import bean.Role;
import dao.MenuDao;
import dao.MiddleDao;
import dao.RoleDao;
import dao.impl.MenuDaoImpl;
import dao.impl.MiddleDaoImpl;
import dao.impl.RoleDaoImpl;
import service.MenuService;
import service.RoleService;

import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class RoleServiceImpl implements RoleService {
    RoleDao roleDao = new RoleDaoImpl();
    MiddleDao middleDao = new MiddleDaoImpl();
    MenuService menuService = new MenuServiceImpl();
    @Override
    public List<Role> getRoleList(int pageIndex, int pageSize) {
        return roleDao.getRoleList(pageIndex,pageSize);
    }

    @Override
    public int total() {
        return roleDao.total();
    }

    @Override
    public int insertRole(String rolename, String state, String[] ids) {
        int key = 0;
        //1.新增角色表
        Role role = new Role();
        role.setRoleName(rolename);
        role.setRoleState(Integer.parseInt(state));
        Integer roleid = roleDao.insertRole(role);
        if (roleid != null){
            key = 1;
        }
        //2.新增中间表
        //如何获取新增数据的id值?
        middleDao.insertMiddle(roleid,ids);
        return key;
    }

    @Override
    public int delete(String roleId) {
        int result = roleDao.delete(roleId);
        int result1 = middleDao.delete(roleId);
        return result;
    }

    @Override
    public Role edit(String roleId) {
        Role role = roleDao.getRoleById(roleId);
        List<Menu> menuList = menuService.getMenuList();
        List<Integer> menuIds = middleDao.getMiddleList(roleId);
        for (Menu menu : menuList) {
            for (Integer menuId : menuIds) {
                if (menu.getMenuId().equals(menuId)){
                    menu.setFlag(true);
                }
                for (Menu menu1 : menu.getSecondMenuList()) {
                    if (menu1.getMenuId().equals(menuId)){
                        menu1.setFlag(true);
                    }
                }
            }
        }
        role.setMenuList(menuList);
        return role;
    }

    @Override
    public Integer update(String roleId, String roleName, String state, String[] menuids) {
        int delete = middleDao.delete(roleId);
        int result = roleDao.update(roleId,roleName,state);
        int id = Integer.parseInt(roleId);
        middleDao.insertMiddle(id,menuids);
        return result;
    }
}
