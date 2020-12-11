package java8_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo_Distinct {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "abc", "jkl");
        List<String> collect = strings.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("**********************************************");
        /*
         * 引用类型内存地址不同，所以不能去重
         */
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity(1,"张三"));
        users.add(new UserEntity(2,"李四"));
        users.add(new UserEntity(3,"王五"));
        users.add(new UserEntity(4,"赵六"));
        users.add(new UserEntity(4,"赵六"));
        List<UserEntity> resultUsers = users.stream().distinct().collect(Collectors.toList());
        System.out.println(resultUsers);

    }
}
