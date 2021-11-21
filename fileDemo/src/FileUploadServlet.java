
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

@WebServlet(urlPatterns = "/uploadtest")
public class FileUploadServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //1.创建上传文件的对象
            SmartUpload smartUpload = new SmartUpload();

            //2.初始化上传操作
            PageContext pageContext = JspFactory.getDefaultFactory()
                    .getPageContext(this, req, resp, null, false, 1024, true);
            smartUpload.initialize(pageContext);
            //2.1 设置编码
            smartUpload.setCharset("utf-8");
            //3.上传
            smartUpload.upload();

            //4.获取文件信息
            File file = smartUpload.getFiles().getFile(0);
            String fileName = file.getFileName();
            String contentType = file.getContentType();

            //获取文本信息
            String uname = smartUpload.getRequest().getParameter("uname");
            System.out.println("uname="+uname);
            //5.指定上传的路径
            String uploadpath="/uploadfiles/"+fileName;
            //6.保存到指定位置
            file.saveAs(uploadpath,File.SAVEAS_VIRTUAL);
            //7.跳转成功页面
            req.setAttribute("filename",fileName);
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }


    }
}
