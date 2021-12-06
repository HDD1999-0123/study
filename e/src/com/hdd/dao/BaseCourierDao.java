package com.hdd.dao;


import com.hdd.bean.Courier;
import com.hdd.bean.User;

import java.util.List;
import java.util.Map;

/**
 * 用于定义eadmin表格的操作规范
 */
public interface BaseCourierDao {
    List<Map<String, Integer>> console();

    List<Courier> findAll(boolean limit, int offset, int pageNumber);

    boolean insert(Courier courier);

    Courier findByPhone(String userphone);

    boolean update(int id, Courier courier);

    boolean delete(int id);
}
