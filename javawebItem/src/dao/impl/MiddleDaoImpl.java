package dao.impl;

import dao.MiddleDao;
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
public class MiddleDaoImpl implements MiddleDao {
    @Override
    public int insertMiddle(Integer roleid, String[] ids) {
        String sql = "insert into middle values(null,?,?)";
        for (String id : ids) {
            List param = new ArrayList();
            param.add(roleid);
            param.add(id);
            try {
                int update = DruidUtil.update(sql, param);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    @Override
    public int delete(String roleId) {
        String sql = "delete from middle where roleid=?";
        List param = new ArrayList();
        param.add(roleId);
        int result = 0;
        try {
            result = DruidUtil.update(sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Integer> getMiddleList(String roleId) {
        String sql = "select * from middle where roleid = ?";
        List param = new ArrayList();
        param.add(roleId);
        List<Integer> menuIds = new ArrayList<>();
        try {
            ResultSet query = DruidUtil.query(sql, param);
            while (query.next()){
                Integer menuId = query.getInt("menuid");
                menuIds.add(menuId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuIds;
    }
}
