package expressDemo.utils;

import java.io.*;

/**
 * @version
 * @ClassName:
 * @Descripton:序列化与反序列化工具类
 * @author: hedd
 */
public class SerializeUtil {
    /**
     * 将对象序列化到指定文件中
     * @param obj
     * @param fileName
     */
    public static void mySerialize(Object obj,String fileName) throws
            IOException {
        OutputStream out=new FileOutputStream(fileName);
        ObjectOutputStream objOut=new ObjectOutputStream(out);
        objOut.writeObject(obj);
        objOut.close();
    }
    /**
     * 从指定文件中反序列化对象
     * @param fileName
     * @return
    1.1.3 测试对象的序列化和反序列化
    运行结果：
     */
    public static Object myDeserialize(String fileName) throws IOException,
            ClassNotFoundException {
        InputStream in=new FileInputStream(fileName);
        ObjectInputStream objIn=new ObjectInputStream(in);
        Object obj=objIn.readObject();
        return obj;
    }

}
