package homework;

import java.util.Scanner;

/**
 * 3. 字符串压缩:利用字符重复出现的次数，编写一种方法，实现基本的字符
 * 串压缩功能。比如,字符串“aabccdd”会变成“a2b1c2d2”。若“压缩”以后的字
 * 符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文
 * 字母(a-z)
 * 示例 1：输入:aabcccccddddd
 * 输出:a2b1c5d5
 * 示例 2：输入：“abcdd” 输出:“abcdd” 解释:因为压缩后的字符串为:”a1b1c1d2”,长度大于原字符串
 */
public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String s = scanner.nextLine();
        String s1 = getS(s);
        System.out.println(s1);
    }
    /*
        转换方法
     */
    public static String getS(String s){
        int js = 1;//计数
        char ch = s.charAt(0);//字符,刚开始时取第一个
        StringBuffer sb = new StringBuffer();
        for (int i = 1;i<s.length();i++){
            //判断字符相等，计数加一
            if(s.charAt(i) == ch){
                js++;
            }else{//否则跳出进行字符串的拼接，重新对ch进行赋值
                sb.append(ch);
                sb.append(js);
                ch = s.charAt(i);
                js=1;
            }
        }
        //最后一个
        sb.append(ch);
        sb.append(js);
        //如果转换后的字符串长度大于或等于初始字符串长度，返回原来的字符串
        if (sb.toString().length() >= s.length()){
            return s;
        }
        return sb.toString();
    }
}
