package com.hdd.servlet;

import com.hdd.bean.Users;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/getuser")
public class GetUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //1.接收参数
        String uid = req.getParameter("uid");
        int userid=Integer.parseInt(uid);
        Users users=null;
        switch (userid){
            case  1:
                users=new Users(1,"张三","abc",11.22);
                break;
            case  2:
                users=new Users(2,"张三2","abc2",222.1);
                break;
            case  3:
                users=new Users(3,"张三3","abc3",33.2);
                break;
            case  4:
                users=new Users(4,"张三4","abc4",44.4);
                break;
            default:
                users=new Users();
        }

        //java->json
        JSONObject jsonObject = JSONObject.fromObject(users);//json

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(jsonObject);

    }
}
