package json;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName:
 * @Descripton:使用Gson将json数据转换成Map对象
 * @author: hedd
 */
public class Demo2 {
    public static void main(String[] args) {
        //1.创建Gson对象
        Gson gson = new Gson();
        //2.转换{"id":"100","name":"hhh","info":"笑死了"}
        Book book = gson.fromJson("{\"id\":\"100\",\"name\":\"hhh\",\"info\":\"笑死了\"}",Book.class);
        System.out.println(book.toString());
        //转换成map
        HashMap data = gson.fromJson("{\"id\":\"100\",\"name\":\"hhh\",\"info\":\"笑死了\",\"page\":[\"锄禾日当午\",\"汗滴禾下土\",\"嘿嘿嘿嘿嘿\"]}",HashMap.class);
        List page = (List) data.get("page");
        System.out.println(page.get(1));
    }
}
