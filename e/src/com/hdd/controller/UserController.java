package com.hdd.controller;

import com.hdd.bean.*;
import com.hdd.mvc.ResponseBody;
import com.hdd.service.AdminService;
import com.hdd.service.ExpressService;
import com.hdd.service.UserService;
import com.hdd.util.DateFormatUtil;
import com.hdd.util.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class UserController {
    @ResponseBody("/user/console.do")
    public String console(HttpServletRequest request, HttpServletResponse response){
        List<Map<String, Integer>> data = UserService.console();
        Message msg = new Message();
        if(data.size() == 0){
            msg.setStatus(-1);
        }else {
            msg.setStatus(0);
        }
        msg.setData(data);
        String json = JSONUtil.toJSON(msg);
        return json;
    }
    @ResponseBody("/user/list.do")
    public String list(HttpServletRequest request, HttpServletResponse response){
        //1.    获取查询数据的起始索引值
        int offset = Integer.parseInt(request.getParameter("offset"));
        //2.    获取当前页要查询的数据量
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        //3.    进行查询
        List<User> list = UserService.findAll(true, offset, pageNumber);
        List<BootStrapTableUser> list2 = new ArrayList<>();
        for(User u:list){
            String createTime = DateFormatUtil.format(u.getCreateTime());
            String loginTime = DateFormatUtil.format(u.getLoginTime());
            BootStrapTableUser u2 = new BootStrapTableUser(u.getId(),u.getUserName(),u.getUserPhone(),u.getPassword(),createTime,loginTime);
            list2.add(u2);
        }
        List<Map<String, Integer>> console = UserService.console();
        Integer total = console.get(0).get("admin_size");
        //4.    将集合封装为 bootstrap-table识别的格式
        ResultData<BootStrapTableUser> data = new ResultData<>();
        data.setRows(list2);
        data.setTotal(total);
        String json = JSONUtil.toJSON(data);
        return json;
    }
}
