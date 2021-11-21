package service;

import bean.Role;
import bean.Users;

import java.util.List;

public interface RoleService {
    /**
     * 查询用户列表
     */
    public List<Role> getRoleList(int pageIndex, int pageSize);
    /**
     * 查询总条数
     */
    public int total();
    public int insertRole(String rolename,String state,String[] ids);

    int delete(String roleId);

    public Role edit(String roleId);

    Integer update(String roleId, String roleName, String state, String[] menuids);
}
