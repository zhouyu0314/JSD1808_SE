package java8_Stream;

import java.util.Arrays;
import java.util.List;

/**
 * 集合中至少有一个元素满足条件返回true
 */
public class Demo1_AnyMatch {
    public static void main(String[] args) {
        List<String> strings1 = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "abc", "jkl");
        boolean b = strings1.stream().anyMatch(str -> str.contains("e"));
        System.out.println(b);
    }
}
