package java8_Stream;


import java.util.Arrays;
import java.util.List;

/**
 * 集合中所有的元素都不满足条件则返回true
 */
public class Demo1_NoneMatch {
    public static void main(String[] args) {
        List<String> strings1 = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "abc", "jkl");
        boolean b = strings1.stream().noneMatch(str -> str.length() > 5);
        System.out.println(b);//true
    }
}
