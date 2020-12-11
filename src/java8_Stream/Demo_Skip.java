package java8_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 跳过流中的前N个元素
 */
public class Demo_Skip {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> result = strings.stream().skip(3).collect(Collectors.toList());
        System.out.println(result);//[efg, abcd, , jkl]
    }
}
