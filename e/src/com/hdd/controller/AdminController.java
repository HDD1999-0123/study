package com.hdd.controller;

import com.hdd.bean.Message;
import com.hdd.mvc.ResponseBody;
import com.hdd.service.AdminService;
import com.hdd.util.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class AdminController {
    @ResponseBody("/admin/login.do")
    public String login(HttpServletRequest request, HttpServletResponse response){
        //1.接参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.调用service传参数，并获取结果
        boolean login = AdminService.login(username, password);
        //3.根据结果，返回不同数据给ajax
        Message message = null;
        if (login){
            message = new Message(0,"登录成功");
            //登录时间和ip的更新
            Date date = new Date();
            String ip = request.getRemoteAddr();
            AdminService.updateLoginTimeAndIP(username,date,ip);
        }else {
            message = new Message(1,"登录失败");
        }
        //4.将数据转化为json
        String s = JSONUtil.toJSON(message);
        //将json回复给ajax
        return s;
    }
}
