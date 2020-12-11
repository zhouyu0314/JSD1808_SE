package java8_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 接受一个函数作为参数。这个函数会被应用到每个元素上，
 * 并将其映射成一个新的元素（使用映射一词，是因为它和转换类似，
 * 但其中的细微差别在于它是“创建一个新版本”而不是去“修改”）。
 */
public class Demo_Map {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "abc", "jkl");
        List<String> result = strings.stream().map(str -> {
            if ("abc".equals(str)) {
                return new StringBuilder(str).reverse().toString();
            }
            return str;
        }).collect(Collectors.toList());
        System.out.println(result);
    }
}
