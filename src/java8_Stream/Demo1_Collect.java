package java8_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 将流转换为其他形式 list set map
 */
public class Demo1_Collect {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd","jkl", "jkl");
//        Set<String> collectSet = strings.stream().collect(Collectors.toSet());
//        System.out.println(collectSet);//[aba, abd, cv, efg, jkl, abcd]
        /*
        用当前的值作为key 当前的值作为value，如果有hash冲突并且equals相等 则用新值(newValue)替换老值(oldValue)
         */
        Map<String, String> collectMap = strings.stream().collect(Collectors.toMap(v -> v, v -> v, (oldValue, newValue) -> newValue));
        System.out.println(collectMap);
    }
}
