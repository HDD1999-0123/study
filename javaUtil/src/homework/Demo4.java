package homework;

/**
 * 4.写一个和 trim 功能相同的方法
 */
public class Demo4 {
    public static void main(String[] args) {
        String s = "   1122 112    ";
        System.out.println(trim(s));
    }
    public static String trim(String s){
        int index1 = 0;//定义前面的一个下标，去除了前面空格后的
        int index2 = s.length()-1;//定义后面的一个下标，去除了后面空格
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ' '){
                index1 = i;
                break;
            }
        }
        for (int i= s.length()-1;i>0;i--){
            if(s.charAt(i) != ' '){
                index2 = i;
                break;
            }
        }
        //截取
        String s2 = s.substring(index1,index2);
        return s2;
    }
}
