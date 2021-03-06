package com.hdd.controller;

import com.hdd.bean.*;
import com.hdd.mvc.ResponseBody;
import com.hdd.service.AdminService;
import com.hdd.service.ExpressService;
import com.hdd.util.DateFormatUtil;
import com.hdd.util.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AdminController {

    @ResponseBody("/admin/login.do")
    public String login(HttpServletRequest request, HttpServletResponse response){
        //1.    接参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.    调用Service传参数，并获取结果
        boolean result = AdminService.login(username, password);
        //3.    根据结果，准备不同的返回数据
        Message msg = null;
        if(result){
            msg = new Message(0,"登录成功");//{status:0,result:"登录成功"}
            //登录时间 和 ip的更新
            Date date = new Date();
            String ip = request.getRemoteAddr();
            AdminService.updateLoginTimeAndIP(username,date,ip);
            request.getSession().setAttribute("adminUserName","username");
        }else{
            msg = new Message(-1,"登录失败");//{status:-1,result:"登录失败"}
        }
        //4.    将数据转换为JSON
        String json = JSONUtil.toJSON(msg);
        //5.    将JSON回复给ajax
        return json;
    }
}
