package service;

import bean.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 查询菜单列表
     */
    public List<Menu> getMenuList();
    /**
     * 查询所有菜单
     */
    public List<Menu> getList();
}
