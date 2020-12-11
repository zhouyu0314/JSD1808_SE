package java8_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用flatMap方法的效果是，各个数组并不是分别映射成一个流，
 * 而是映射成流的内容。所有使用map(Arrays::stream)时生成的单个流都被合并起来，
 * 即扁平化为一个流。
 */
public class Demo_FlatMap {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "abc", "jkl");
        /**
         * 可以将众多的流合并成一个 [a,b,c] [a,b,c]...[j,k,1] -> [a,b,c,a,b,c...j,k,1]
         */
        Stream<Character> characterStream = strings.stream().flatMap(str -> Demo_FlatMap.getCharacterByString(str));
        List<Character> flatMaped = characterStream.collect(Collectors.toList());
        System.out.println(flatMaped);//[a, b, c, a, b, c, b, c, e, f, g, a, b, c, d, a, b, c, j, k, l]
        Stream<Stream<Character>> streamStream = strings.stream().map(str -> Demo_FlatMap.getCharacterByString(str));
        streamStream.forEach(stream -> {
            List<Character> collect = stream.collect(Collectors.toList());
            System.out.println(collect);
            /*
             * [a, b, c]
                [a, b, c]
                [b, c]
                [e, f, g]
                [a, b, c, d]
                [a, b, c]
                [j, k, l]
             */
        });
    }

    /**
     * 功能描述:字符串转换为字符流
     *
     * @param str
     * @return : java.util.stream.Stream<java.lang.Character>
     */
    public static Stream<Character> getCharacterByString(String str) {
        List<Character> characterList = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            characterList.add(character);
        }
        return characterList.stream();
    }


}





