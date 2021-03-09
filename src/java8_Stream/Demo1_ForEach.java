package java8_Stream;

import java.util.Arrays;
import java.util.List;

public class Demo1_ForEach {
    //asdasd
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        strings.stream().forEach(str -> System.out.println(str));
    }
}
