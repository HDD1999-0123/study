package homework.web;

import homework.bean.RequestBody;
import homework.bean.ResponseBody;
import homework.bean.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName:
 * @Descripton:客户端2
 * @author: hedd
 */
public class Client1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1",19999);
        System.out.println("请输入身份（管理员/用户）：");
        String role = input.nextLine();
        System.out.println("请输入用户名：");
        String name = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        RequestBody requestBody = new RequestBody();
        requestBody.setCmd(role);
        requestBody.setUser(user);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(requestBody);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ResponseBody responseBody = (ResponseBody) ois.readObject();
        if (responseBody.getResult() == 1){
            System.out.println("管理员登录成功");
        }
        if (responseBody.getResult() == 2){
            System.out.println("用户登录成功");
        }
        if (responseBody.getResult() == 0){
            System.out.println("登录失败");
        }
    }
}
