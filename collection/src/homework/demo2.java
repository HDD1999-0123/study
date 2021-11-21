package homework;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 2、已知数组存放一批 QQ 号码,长度 5-11 位，
 * String[] strs = {"10001","10086","12347806666","45612378901","10001","12347806666"}。
 * 将该数组里面的所有 qq 号都存放在 LinkedList 中，将 list 中重复元素删
 * 除，将 list 中所有元素分别用迭代器和增强 for 循环打印出来。
 */
public class demo2 {
    public static void main(String[] args) {
        String[] strs = {"10001","10086","12347806666","45612378901","10001","12347806666"};
        LinkedList<String> list = new LinkedList<>();
        for (String str : strs) {
           if(!list.contains(str)){//不重复的才加进list中
               list.add(str);
           }
        }
        //迭代器的方式
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("***********************");
        //增强for循环的方式
        for (String s : list) {
            System.out.println(s);
        }
    }
}
