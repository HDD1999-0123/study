package servlet;

import net.sf.json.JSONObject;
import service.StudentListService;
import service.impl.StudentListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
@WebServlet(urlPatterns = "/Educational/student/verify")
public class StudentNoVerifyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentListService studentListService = new StudentListServiceImpl();
        String stuno = req.getParameter("stuno");
        boolean result = studentListService.verify(stuno);
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        //java->json
        JSONObject jsonObject = JSONObject.fromObject(map);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(jsonObject);
    }
}
