package java8_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 过滤集合中不符合条件的元素
 */
public class Demo_Filter {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> result = strings.stream().filter(str -> str.contains("f")).collect(Collectors.toList());
        System.out.println(result);
        System.out.println("**********************************************");
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity(1,"张三"));
        users.add(new UserEntity(2,"李四"));
        users.add(new UserEntity(3,"王五"));
        users.add(new UserEntity(4,"赵六"));
        users.add(new UserEntity(5,"田七"));

        List<UserEntity> resultUsers = users.stream().filter(entity -> !"田七".equals(entity.getName())).collect(Collectors.toList());
        System.out.println(resultUsers);

    }
}
