package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、定义一个方法 listTest(ArrayList<String> list, String name)，要求返回
 * name 在 list 里面第一次出现的索引，如果 name 没出现过返回-1。
 */
public class demo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("xiaohong");
        list.add("xiaolv");
        list.add("dabai");
        System.out.println(listTest(list, "xiaolv"));
    }
    public static int listTest(ArrayList<String> list,String name){
        for (int i=0;i<list.size();i++){
            if (name.equals(list.get(i))){
                return i;
            }
        }
        return -1;
    }
}
