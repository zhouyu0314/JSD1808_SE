package set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo01 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("啊");
        set.add("是");
        set.add("的");
        set.add("我");
        set.add("去");


        System.out.println(set);
    }
}
