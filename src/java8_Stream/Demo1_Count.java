package java8_Stream;

import java.util.Arrays;
import java.util.List;

public class Demo1_Count {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "abc", "jkl");
        System.out.println(strings.stream().count());//7
    }
}
