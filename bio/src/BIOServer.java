import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName:
 * @Descripton: 服务器端
 * @author: hedd
 */
public class BIOServer {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            //服务器
            ServerSocket serverSocket = new ServerSocket(10086);
            System.out.println("服务器启动----端口号是10086");
            while (true){
                //连接到客户端---堵塞方法
                Socket client = serverSocket.accept();
                System.out.println("有客户端连接成功！");
                //为每一个客户端连接都创建一个新的线程与之通信
                executorService.execute(()->{
                    System.out.println("线程id"+Thread.currentThread().getId());
                    System.out.println("线程名称"+Thread.currentThread().getName());
                    try {
                        int len = 0;
                        byte[] byteArr=new byte[1024];
                        //读取来自客户端的数据
                        InputStream inputStream = client.getInputStream();
                        while ((len=inputStream.read(byteArr))!=-1){
                            String msg = new String(byteArr);
                            System.out.println("来自客户端的信息："+msg);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                });

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
