package dao;

import bean.Users;

import java.util.List;

public interface UserDao {
    /**
     * 查询用户列表
     */
    public List<Users> getUsersList(int pageIndex, int pageSize);
    /**
     * 查询总条数
     */
    public int total();
}
