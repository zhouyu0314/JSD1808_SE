package java8_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 返回当前流中任意元素
 */
public class Demo1_FindAny {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd","jkl", "jkl");
        Optional<String> any = strings.stream().findAny();
        if(any.isPresent()) System.out.println(any.get());
    }

}
