package java8_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取流中的前N个元素，不存在下标越界
 */
public class Demo_Limit {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> result = strings.stream().limit(2).collect(Collectors.toList());
        System.out.println(result);
    }
}
