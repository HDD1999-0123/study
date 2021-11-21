package com.hdd.controller;

import com.hdd.mvc.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class TestController {
    @ResponseBody("/login.do")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("123");
    }
}
