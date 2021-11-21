package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @ClassName:
 * @Descripton:解析本地xml
 * @author: hedd
 */
public class Demo1 {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        //获取文件的输入流
        FileInputStream fis = new FileInputStream("D:\\1.xml");
        //创建xml读取文件对象
        SAXReader sr = new SAXReader();
        //通过读取工具，读取xml文档的输入流，并得到文档对象
        Document doc = sr.read(fis);
        //通过文档对象，读取文档的根节点对象
        Element element = doc.getRootElement();
        //通过根节点，获取所有的子节点
        List<Element> list = element.elements();
        for (Element element1 : list) {
            //输出所有子节点的名称
            System.out.println(element1.getName());
            //获取id属性值
            String id = element1.attributeValue("id");
            System.out.println(id);
            //获取子节点name，并获取它的内容
            String name = element1.element("name").getText();
            System.out.println(name);
        }
    }
}
