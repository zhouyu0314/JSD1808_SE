package java8_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 将流中元素反复结合起来得到一个结果
 */
public class Demo1_Reduce {
    public static void main(String[] args) {
        List<String> strings1 = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "abc", "jkl");
        /*
        acc是相加的结果，item是每一个元素，初始acc是空
         */
        Optional<String> reduce = strings1.stream().reduce((acc, item) -> {
            return acc + item;
        });
        if (reduce.isPresent()) {
            System.out.println(reduce.get());
        }
    }
}
