package dao.impl;

import bean.Users;
import dao.LoginDao;
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
public class LoginDaoImpl implements LoginDao {
    @Override
    public Users login(Users users) {
        String sql = "select * from users where loginName = ? and password = ?";
        List<Object> list = new ArrayList<>();
        Users users1 = new Users();
        list.add(users.getLoginName());
        list.add(users.getPassWord());
        ResultSet query = null;
        int result = 0;
        try {
            query = DruidUtil.query(sql, list);
            while (query.next()){
                users1.setUserId(query.getInt("userid"));
                users1.setLoginName(query.getString("loginname"));
                users1.setRealName(query.getString("realname"));
                users1.setRoleId(query.getInt("roleid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users1;
    }
}
