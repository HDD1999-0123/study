package com.hdd.service;


import com.hdd.bean.Courier;
import com.hdd.bean.User;
import com.hdd.dao.BaseCourierDao;
import com.hdd.dao.BaseUserDao;
import com.hdd.dao.imp.CourierDaoMysql;
import com.hdd.dao.imp.UserDaoMysql;

import java.util.List;
import java.util.Map;

public class CourierService {

    private static BaseCourierDao dao = new CourierDaoMysql();
    public static List<Map<String, Integer>> console() {
        return dao.console();
    }

    public static List<Courier> findAll(boolean limit, int offset, int pageNumber) {
        return dao.findAll(limit,offset,pageNumber);
    }

    public static boolean insert(Courier courier) {
        boolean flag = dao.insert(courier);
        return flag;
    }

    public static Courier findByPhone(String userphone) {
        return dao.findByPhone(userphone);
    }

    public static boolean update(int id, Courier courier) {
        return dao.update(id,courier);
    }

    public static boolean delete(int id) {
        return dao.delete(id);
    }
}
