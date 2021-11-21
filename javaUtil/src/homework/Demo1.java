package homework;

/**
 * 1.编写一个方法，将一段文本中的各个单词的字母顺序翻转，
 * 例如："I like writing code best"，将变成"I ekil gnitirw edoc tseb"。
 */
public class Demo1 {
    public static String flip(String s){
        String[] source = s.split(" ");//将这串语句通过空格进行分割，取得各个单词
        StringBuilder stringBuilder = new StringBuilder();
        /*
            循环字符串数组，对每个单词进行操作
         */
        for (String s1 : source) {
            StringBuffer stringBuffer = new StringBuffer(s1);
            //使用stringBuffer的内置方法进行翻转操作
            String newWord = stringBuffer.reverse().toString();
            //使用StringBuilder将处理后的单词重新拼接成语句
            stringBuilder.append(newWord+" ");
        }
        //删除最后一个空字符
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = flip("I like writing code best");
        System.out.println(s);
    }
}
