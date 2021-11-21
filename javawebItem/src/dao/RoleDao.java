package dao;

import bean.Role;
import bean.Users;

import java.util.List;

public interface RoleDao {
    /**
     * 查询用户列表
     */
    public List<Role> getRoleList(int pageIndex, int pageSize);
    /**
     * 查询总条数
     */
    public int total();

    int insertRole(Role role);

    int delete(String roleId);

    Role getRoleById(String roleId);

    int update(String roleId, String roleName, String state);

    Role findById(Integer roleId);
}
