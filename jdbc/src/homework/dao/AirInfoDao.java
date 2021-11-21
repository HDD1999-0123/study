package homework.dao;

import homework.bean.AirInfo;

import java.sql.SQLException;
import java.util.List;

public interface AirInfoDao {
    //列出所有的航班信息
    public List<AirInfo> getAllList();
    // 按起飞时间查询
    public List<AirInfo> getByDate(String date);
    // 按目的地查询
    public List<AirInfo> getByDestination(String destination);
    //删除航班
    public boolean deleteByAirNum(Integer airNum);
    //更新航班
    boolean updateById(AirInfo airInfo);

}
