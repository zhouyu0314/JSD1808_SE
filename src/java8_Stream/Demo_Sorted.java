package java8_Stream;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo_Sorted {
    public static void main(String[] args) {
        List<String> strings1 = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "abc", "jkl");
        List<String> strings2 = Arrays.asList("张三", "李四", "王五", "张武", "老李", "赵六", "赵四");
        List<UserEntity> strings3 = Arrays.asList(
                new UserEntity(1, "张三"),
                new UserEntity(7, "李四"),
                new UserEntity(3, "王五"),
                new UserEntity(4, "张武"),
                new UserEntity(5, "老李"),
                new UserEntity(6, "赵六"),
                new UserEntity(2, "赵四"));
        //Stream<String> stream1 = strings1.stream();
        //List<String> result1 = stream1.sorted().collect(Collectors.toList());
        System.out.println("*******************英文正序*************************");
        //System.out.println(result1);//[abc, abc, abc, abcd, bc, efg, jkl]
        System.out.println("*******************英文倒叙*************************");
//        List<String> result2 = stream1.sorted(Collections.reverseOrder()).collect(Collectors.toList());
//        System.out.println(result2);//[jkl, efg, bc, abcd, abc, abc, abc]
        System.out.println("*******************中文正序*************************");
        //Stream<String> stream2 = strings2.stream();
//        List<String> result3 = stream2.sorted(Collator.getInstance(Locale.CHINA)).collect(Collectors.toList());
//        System.out.println(result3);//[老李, 李四, 王五, 张三, 张武, 赵六, 赵四]
        System.out.println("*******************中文倒序*************************");
//        List<String> result4 = stream2.sorted(Collections.reverseOrder(Collator.getInstance(Locale.CHINA))).collect(Collectors.toList());
//        System.out.println(result4);//[赵四, 赵六, 张武, 张三, 王五, 李四, 老李]
        System.out.println("*******************对象排序*************************");
        List<UserEntity> result5 = strings3.stream().sorted(Comparator.comparing(userEntity -> userEntity.getName())).collect(Collectors.toList());
        System.out.println(result5);


    }

}
