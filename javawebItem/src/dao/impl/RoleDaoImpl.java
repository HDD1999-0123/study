package dao.impl;

import bean.Menu;
import bean.Role;
import bean.Users;
import dao.RoleDao;
import service.RoleService;
import utils.DruidUtil;

import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class RoleDaoImpl implements RoleDao {
    @Override
    public List<Role> getRoleList(int pageIndex, int pageSize) {
        String sql = "select * from role limit ?,?";
        List<Role> roleList= new ArrayList<>();
        List param = new ArrayList();
        param.add((pageIndex-1)*pageSize);
        param.add(pageSize);
        try {
            ResultSet query = DruidUtil.query(sql, param);
            while (query.next()){
                //1.取出各表的数据
                Role role = new Role();
                role.setRoleId(query.getInt("roleid"));
                role.setRoleName(query.getString("rolename"));
                role.setRoleState(query.getInt("rolestate"));
                roleList.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public int total() {
        String sql = "select count(1) from role";
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

    @Override
    public int insertRole(Role role) {
        String sql = "insert into role values(null,?,?)";
        List param = new ArrayList();
        //新增数据的id
        int key = 0;
        param.add(role.getRoleName());
        param.add(role.getRoleState());
        try {
            int result = DruidUtil.update(sql, param);
            ResultSet generatedKeys = DruidUtil.ps.getGeneratedKeys();
            if (generatedKeys.next()){
                key = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    @Override
    public int delete(String roleId) {
        String sql = "delete from role where roleid=?";
        List param = new ArrayList();
        int result = 0;
        param.add(Integer.parseInt(roleId));
        try {
            result = DruidUtil.update(sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Role getRoleById(String roleId) {
        List param =new ArrayList();
        String sql = "select * from role where roleid = ?";
        param.add(roleId);
        Role role = new Role();
        try {
            ResultSet query = DruidUtil.query(sql, param);
            while (query.next()){
                role.setRoleName(query.getString("rolename"));
                role.setRoleState(query.getInt("rolestate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public int update(String roleId, String roleName, String state) {
        String sql = "update role set rolename=?,rolestate=? where roleid = ?";
        List param = new ArrayList();
        param.add(roleName);
        param.add(state);
        param.add(Integer.parseInt(roleId));
        int result = 0;
        try {
            result = DruidUtil.update(sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Role findById(Integer roleId) {
        Role role = new Role();
        List menuList = new ArrayList();
        String sql = "select * from role r,menu m,middle mid where r.roleid=mid.roleid and mid.menuid=m.menuid and r.roleid=?";
        List param = new ArrayList();
        param.add(roleId);
        try {
            ResultSet query = DruidUtil.query(sql, param);
            while (query.next()){
                role.setRoleId(query.getInt("roleid"));
                role.setRoleName(query.getString("rolename"));
                role.setRoleState(query.getInt("rolestate"));
                Menu menu = new Menu();
                menu.setMenuId(query.getInt("menuid"));
                menu.setMenuName(query.getString("menuname"));
                menu.setUrl(query.getString("url"));
                menu.setState(query.getInt("state"));
                menu.setUpmenuId(query.getInt("upmenuid"));
                menuList.add(menu);
            }
            role.setMenuList(menuList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
}
