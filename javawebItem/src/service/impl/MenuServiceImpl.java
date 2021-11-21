package service.impl;

import bean.Menu;
import dao.MenuDao;
import dao.impl.MenuDaoImpl;
import service.MenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class MenuServiceImpl implements MenuService {
    MenuDao menuDao = new MenuDaoImpl();
    @Override
    public List<Menu> getMenuList() {
        //未分1，2级
        List<Menu> menuList = menuDao.getMenuList();
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
        return newMenuList;
    }

    @Override
    public List<Menu> getList() {
        return menuDao.getList();
    }
}
