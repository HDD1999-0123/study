import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
@WebServlet(urlPatterns = "/downimg")
public class FileDownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("filename");
        String url = "/uploadfiles/"+name;
        //将响应的内容设置为通用的二进制流
        resp.setContentType("application/octet-stream");
        //attachment 告诉浏览器以附件的方式下载文件（弹出下载框)
        name = URLEncoder.encode(name,"utf-8");
        resp.addHeader("Content-Disposition","attachment;filename="+name);
        req.getRequestDispatcher(url).forward(req,resp);
        //清空缓冲区：将服务端缓冲区的文件内容，立即全部传输给客户端
        resp.flushBuffer();
    }
}
