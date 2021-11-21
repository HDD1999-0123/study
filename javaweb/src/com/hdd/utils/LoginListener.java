package com.hdd.utils;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName:
 * @Descripton: session监听
 * @author: hedd
 */
public class LoginListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session销毁");
    }
}
