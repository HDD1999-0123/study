package service.impl;

import bean.Menu;
import bean.Role;
import bean.Users;
import dao.LoginDao;
import dao.RoleDao;
import dao.impl.LoginDaoImpl;
import dao.impl.RoleDaoImpl;
import service.LoginService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = new LoginDaoImpl();
    RoleDao roleDao = new RoleDaoImpl();
    @Override
    public Users login(Users users) {
        Users u = loginDao.login(users);
        if (u==null){
            return null;
        }
        //根据角色id查询角色，菜单信息（三表）
        Integer roleId = u.getRoleId();
        Role role = roleDao.findById(roleId);
        //需要对菜单进行分级
        List<Menu> menuList = role.getMenuList();
        //保存分级后的菜单
        List<Menu> newMenuList = new ArrayList<>();
        for (Menu menu : menuList) {
            //说明是1级菜单
            if (menu.getUpmenuId() == 0){
                //用来保存二级菜单
                List<Menu> secondMenuList = new ArrayList<>();
                for (Menu second : menuList) {
                    if (second.getUpmenuId() == menu.getMenuId()){
                        secondMenuList.add(second);
                    }
                }
                //将二级列表放到以及列表的对象中
                menu.setSecondMenuList(secondMenuList);
                //分级后的列表
                newMenuList.add(menu);
            }
        }
        role.setMenuList(newMenuList);
        u.setRole(role);
        return u;
    }
}
