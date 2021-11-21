package homework.web;

import homework.bean.RequestBody;
import homework.bean.ResponseBody;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName:
 * @Descripton:服务器
 * @author: hedd
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(19999);
        while(true) {
            Socket socket = server.accept();
            //输出连接的客户端的端口号
            System.out.println(socket.getPort());
            //创建线程，处理用户登录
            new Thread(() -> {
                try {
                    //创建输入流，接受用户输入的信息
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    RequestBody requestBody = (RequestBody) ois.readObject();
                    ResponseBody responseBody = new ResponseBody();
                    //通过输入的角色，判断当前是要登管理员还是用户账号
                    switch (requestBody.getCmd()) {
                        case "admin":
                            if ("admin".equals(requestBody.getUser().getName()) && "abc".equals(requestBody.getUser().getPassword())) {
                                responseBody.setResult(1);
                            } else {
                                responseBody.setResult(0);
                            }
                            break;
                        case "user":
                            if ("user".equals(requestBody.getUser().getName()) && "123".equals(requestBody.getUser().getPassword())) {
                                responseBody.setResult(2);
                            } else {
                                responseBody.setResult(0);
                            }
                            break;
                    }
                    //创建输出流，传回结果到客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(responseBody);
                    oos.close();
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }).start();

        }

    }
}
