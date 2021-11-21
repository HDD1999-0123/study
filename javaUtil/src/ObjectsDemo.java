import java.util.Comparator;
import java.util.Objects;

public class ObjectsDemo {
    public static void main(String[] args) {
        boolean b = Objects.equals(null, "111");
        System.out.println(b);
        boolean i = Objects.isNull(null);
        System.out.println(i);
        System.out.println(Objects.hashCode("123"));
        int hash = Objects.hash("1", "2");
        System.out.println(hash);
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1;
            }
        };
        System.out.println(Objects.compare("12", "12", c));//如果前两个参数相等，返回0，否则返回第三个参数返回的值。
    }
}
