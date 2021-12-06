package com.hdd.service;


import com.hdd.bean.User;
import com.hdd.dao.BaseUserDao;
import com.hdd.dao.imp.UserDaoMysql;
import com.hdd.exception.DuplicateCodeException;
import com.hdd.util.RandomUtil;
import com.hdd.util.SMSUtil;

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

    public static boolean insert(User user) {
        boolean flag = dao.insert(user);
        return flag;
    }

    public static User findByPhone(String userphone) {
        return dao.findByPhone(userphone);
    }

    public static boolean update(int id, User user) {
        return dao.update(id,user);
    }

    public static boolean delete(int id) {
        return dao.delete(id);
    }
}
