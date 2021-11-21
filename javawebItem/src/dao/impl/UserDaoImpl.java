package dao.impl;

import bean.Role;
import bean.Users;
import dao.UserDao;
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
public class UserDaoImpl implements UserDao {
    @Override
    public List<Users> getUsersList(int pageIndex, int pageSize) {
        String sql = "select userid,loginname,realname,rolename from users u,role r where u.roleid=r.roleid limit ?,?";
        List<Users> usersList= new ArrayList<>();
        List param = new ArrayList();
        param.add((pageIndex-1)*pageSize);
        param.add(pageSize);
        try {
            ResultSet query = DruidUtil.query(sql, param);
            while (query.next()){
                //1.取出各表的数据
                Users users = new Users();
                users.setUserId(query.getInt("userid"));
                users.setLoginName(query.getString("loginname"));
                users.setRealName(query.getString("realname"));
                Role role = new Role();
                role.setRoleName(query.getString("rolename"));
                //建立关系
                users.setRole(role);
                usersList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public int total() {
        String sql = "select count(1) from users u,role r where u.roleid=r.roleid";
        int result = 0;
        try {
            ResultSet query = DruidUtil.query(sql, null);
            while (query.next()){
                result=query.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
