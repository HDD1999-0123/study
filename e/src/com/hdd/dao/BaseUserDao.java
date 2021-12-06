package com.hdd.dao;


import com.hdd.bean.User;

import java.util.List;
import java.util.Map;

/**
 * 用于定义eadmin表格的操作规范
 */
public interface BaseUserDao {
    List<Map<String, Integer>> console();

    List<User> findAll(boolean limit, int offset, int pageNumber);

    boolean insert(User user);

    User findByPhone(String userphone);

    boolean update(int id, User user);

    boolean delete(int id);
}
