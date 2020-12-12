package java8_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo1_FindFirst {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd","jkl", "jkl");
        Optional<String> first = strings.stream().findFirst();
        if(first.isPresent()) System.out.println(first.get());
    }
}
