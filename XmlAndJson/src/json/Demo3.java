package json;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName:
 * @Descripton:使用fastJson，将对象转换为json数据
 * @author: hedd
 */
public class Demo3 {
    public static void main(String[] args) {
        Book book = new Book("1002","hhhhhhhh","笑就完了");
        //转换
        String json = JSON.toJSONString(book);
        System.out.println(json);
    }
}
