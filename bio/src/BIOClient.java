import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class BIOClient {
    public static void main(String[] args) {
        try {
            //创建客户端
            Socket client = new Socket("127.0.0.1", 10086);
            String msg = "hello word";
            OutputStream outputStream = client.getOutputStream();
            outputStream.write(msg.getBytes(StandardCharsets.UTF_8),0,msg.length());
            outputStream.close();
            System.in.read();//目的是让客户端保持与服务器的连接
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
