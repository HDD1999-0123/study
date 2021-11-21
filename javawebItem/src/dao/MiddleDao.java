package dao;

import java.util.List;

public interface MiddleDao {
    //新增角色
    public int insertMiddle(Integer roleid,String[] ids);

    int delete(String roleId);

    List<Integer> getMiddleList(String roleId);
}
