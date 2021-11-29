package com.hdd.service;


import com.hdd.bean.User;
import com.hdd.dao.BaseUserDao;
import com.hdd.dao.imp.UserDaoMysql;

import java.util.List;
import java.util.Map;

public class UserService {

    private static BaseUserDao dao = new UserDaoMysql();
    public static List<Map<String, Integer>> console() {
        return dao.console();
    }

    public static List<User> findAll(boolean limit, int offset, int pageNumber) {
        return dao.findAll(limit,offset,pageNumber);
    }
}
