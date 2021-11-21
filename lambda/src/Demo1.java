import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName:
 * @Descripton: stream
 * @author: hedd
 */

public class Demo1 {
    public static void main(String[] args) {
        //创建一个Stream流
        Stream<String> stringStream = Stream.of("q", "e", "w");
        Stream<String> stringStream1 = Stream.of("e", "d");
        //将两个Stream流连接起来
        Stream<String> stringStream2 = Stream.concat(stringStream, stringStream1);
        //输出
//        System.out.println(stringStream2.collect(Collectors.toList()));
        Stream<Integer> integerStream = Stream.of(1, 5, 3, 9);
        //获取最大值
//        Integer integer = integerStream.max(Integer::compareTo).get();
//        System.out.println(integer);
        //获取第一个值
//        Optional<Integer> first = integerStream.findFirst();
//        if (first.isPresent()){
//            System.out.println(first.get());
//        }
        //建立一个通道，在这个通道中对 Stream 的每个元素执行对应的操作
//        List<String> collect = stringStream2.peek(e -> System.out.println(e.toUpperCase())).collect(Collectors.toList());
        /*
        和 peek 方法类似，都接收一个消费者函数式接口，可以对每个元素进行对应的操作，
        但是和 peek 不同的是，forEach 执行之后，这个 Stream 就真的被消费掉了，
        之后这个 Stream 流就没有了，不可以再对它进行后续操作了，而 peek操作完之后，
        还是一个可操作的 Stream 对象。
         */
//        stringStream2.forEach(e->System.out.println(e.toUpperCase()));
        //获取前n条数
//        stringStream2.limit(2).forEach(System.out::println);
        //跳过几条
//        stringStream2.skip(2).forEach(System.out::println);
        //去重
//        stringStream2.distinct().forEach(System.out::println);
        //排序
//        stringStream2.sorted().forEach(System.out::println);
        //过滤条件
        stringStream2.filter("e"::equals).forEach(System.out::println);
    }
}
