package com.hdd.controller;

import com.hdd.bean.*;
import com.hdd.mvc.ResponseBody;
import com.hdd.service.AdminService;
import com.hdd.service.ExpressService;
import com.hdd.service.UserService;
import com.hdd.util.DateFormatUtil;
import com.hdd.util.JSONUtil;
import com.hdd.util.UserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiDevice;
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
            String loginTime = null;
            if (u.getLoginTime() != null){
                loginTime = DateFormatUtil.format(u.getLoginTime());
            }
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
    @ResponseBody("/user/insert.do")
    public String insert(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String userphone = request.getParameter("userphone");
        String idcard = request.getParameter("idcard");
        String password = request.getParameter("password");
        User user = new User(username,userphone,password,idcard);
        boolean flag = UserService.insert(user);
        Message msg = new Message();
        if(flag){
            //录入成功
            msg.setStatus(0);
            msg.setResult("快递录入成功!");
        }else{
            //录入失败
            msg.setStatus(-1);
            msg.setResult("快递录入失败!");
        }
        String json = JSONUtil.toJSON(msg);
        return json;
    }
    @ResponseBody("/user/find.do")
    public String find(HttpServletRequest request,HttpServletResponse response){
        String userphone = request.getParameter("userphone");
        User user = UserService.findByPhone(userphone);
        Message msg = new Message();
        if(user == null){
            msg.setStatus(-1);
            msg.setResult("手机号不存在");
        }else{
            msg.setStatus(0);
            msg.setResult("查询成功");
            msg.setData(user);
        }
        String json = JSONUtil.toJSON(msg);
        return json;
    }

    @ResponseBody("/user/update.do")
    public String update(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String userPhone = request.getParameter("userphone");
        String password = request.getParameter("password");
        String idcard = request.getParameter("idcard");
        User user = new User();
        user.setUserName(username);
        user.setUserPhone(userPhone);
        user.setPassword(password);
        user.setIdcard(idcard);
        boolean flag = UserService.update(id, user);
        Message msg = new Message();
        if(flag){
            msg.setStatus(0);
            msg.setResult("修改成功");
        }else{
            msg.setStatus(-1);
            msg.setResult("修改失败");
        }
        String json = JSONUtil.toJSON(msg);
        return json;
    }

    @ResponseBody("/user/delete.do")
    public String delete(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        boolean flag = UserService.delete(id);
        Message msg = new Message();
        if(flag){
            msg.setStatus(0);
            msg.setResult("删除成功");
        }else{
            msg.setStatus(-1);
            msg.setResult("删除失败");
        }
        String json = JSONUtil.toJSON(msg);
        return json;
    }
}
