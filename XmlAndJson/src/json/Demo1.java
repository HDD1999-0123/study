package json;

import com.google.gson.Gson;

/**
 * @ClassName:
 * @Descripton:使用Gson将对象转成json
 * @author: hedd
 */
public class Demo1 {
    public static void main(String[] args) {
        //1.创建Gson对象
        Gson gson = new Gson();
        //2.转换
        Book book = new Book("100","hhh","笑死了");
        String bookJson = gson.toJson(book);
        System.out.println(bookJson);
    }
}
