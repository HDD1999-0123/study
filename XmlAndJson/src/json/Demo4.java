package json;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName:
 * @Descripton:fastJson将json数据转换为对象
 * @author: hedd
 */
public class Demo4 {
    public static void main(String[] args) {
        //转换
        Book book = JSON.parseObject("{\"id\":\"1002\",\"info\":\"笑就完了\",\"name\":\"hhhhhhhh\"}", Book.class);
        System.out.println(book);
    }
}
