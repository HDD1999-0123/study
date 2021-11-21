package homework.dao.impl;

import homework.bean.AirInfo;
import homework.dao.AirInfoDao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class AirInfoDaoImpl implements AirInfoDao{
    @Override
    public List<AirInfo> getAllList() {
        String sql = "select id,airNum,destination,airDate from airinfo";
        List<Object> list = new ArrayList<>();
        ResultSet resultSet = null;
        List<AirInfo> airInfos = new ArrayList<>();
        try {
             resultSet= DruidUtil.query(sql, list);
             while (resultSet.next()){
                 AirInfo airInfo = new AirInfo();
                 airInfo.setId(resultSet.getInt("id"));
                 airInfo.setAirNum(resultSet.getString("airNum"));
                 airInfo.setDestination(resultSet.getString("destination"));
                 airInfo.setAirDate((Date)resultSet.getDate("airDate"));
                 airInfos.add(airInfo);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return airInfos;
    }

    @Override
    public List<AirInfo> getByDate(String date) {
        String sql = "select id,airNum,destination,airDate from airinfo where airDate = ?";
        List<Object> list = new ArrayList<>();
        List<AirInfo> airInfos = new ArrayList<>();
        ResultSet resultSet = null;
        list.add(date);
        try {
            resultSet = DruidUtil.query(sql,list);
            while (resultSet.next()){
                AirInfo airInfo = new AirInfo();
                airInfo.setId(resultSet.getInt("id"));
                airInfo.setAirNum(resultSet.getString("airNum"));
                airInfo.setDestination(resultSet.getString("destination"));
                airInfo.setAirDate((Date)resultSet.getDate("airDate"));
                airInfos.add(airInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airInfos;
    }

    @Override
    public List<AirInfo> getByDestination(String destination) {
        String sql = "select id,airNum,destination,airDate from airinfo where destination = ?";
        List<Object> list = new ArrayList<>();
        List<AirInfo> airInfos = new ArrayList<>();
        ResultSet resultSet = null;
        list.add(destination);
        try {
            resultSet = DruidUtil.query(sql,list);
            while (resultSet.next()){
                AirInfo airInfo = new AirInfo();
                airInfo.setId(resultSet.getInt("id"));
                airInfo.setAirNum(resultSet.getString("airNum"));
                airInfo.setDestination(resultSet.getString("destination"));
                airInfo.setAirDate((Date)resultSet.getDate("airDate"));
                airInfos.add(airInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airInfos;
    }

    @Override
    public boolean deleteByAirNum(Integer id) {
        String sql = "delete from airinfo where id = ?";
        List<Object> list = new ArrayList<>();
        list.add(id);
        int result = 0;
        try {
            result = DruidUtil.update(sql,list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    @Override
    public boolean updateById(AirInfo airInfo) {
        String sql = "update airinfo set airNum = ?,destination = ?,airDate = ? where id = ?";
        List<Object> list = new ArrayList<>();
        list.add(airInfo.getAirNum());
        list.add(airInfo.getDestination());
        list.add(airInfo.getAirDate());
        list.add(airInfo.getId());
        int update = 0;
        try {
            update = DruidUtil.update(sql, list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update>0;
    }
}
