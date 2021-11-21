import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version
 * @ClassName:
 * @Descripton:客户端
 * @author: hedd
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",29833);
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("你好，服务器");
    }
}
