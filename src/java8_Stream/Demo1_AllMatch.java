package java8_Stream;

import java.util.Arrays;
import java.util.List;

/**
 * 集合中所有的元素都满足条件返回true
 */
public class Demo1_AllMatch {
    public static void main(String[] args) {
        List<String> strings1 = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "abc", "jkl");
        boolean b = strings1.stream().allMatch(str -> str.length() > 0);
        System.out.println(b);//true
    }
}
