package dao.impl;

import bean.Menu;
import dao.MenuDao;
import utils.DruidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class MenuDaoImpl implements MenuDao {
    @Override
    public List<Menu> getMenuList() {
        List<Menu> menuList = new ArrayList<>();
        String sql = "select * from menu";
        try {
            ResultSet query = DruidUtil.query(sql, null);
            while (query.next()){
                Menu menu = new Menu();
                menu.setMenuId(query.getInt("menuid"));
                menu.setMenuName(query.getString("menuname"));
                menu.setUpmenuId(query.getInt("upmenuid"));
                menu.setState(query.getInt("state"));
                menu.setDesc(query.getString("desc"));
                menu.setUrl(query.getString("url"));
                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public List<Menu> getList() {
        String sql = "select * from menu";
        List<Menu> menuList = new ArrayList<>();
        try {
            ResultSet query = DruidUtil.query(sql, null);
            while (query.next()){
                Menu menu = new Menu();
                String menuName = query.getString("menuname");
                String url = query.getString("url");
                Integer state = query.getInt("state");
                menu.setMenuName(menuName);
                menu.setUrl(url);
                menu.setState(state);
                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }
}
