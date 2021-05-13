package test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import java8_Stream.UserEntity;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("A");
        list.add("B");
        list.add("B");
        list.add("C");

       Set hashMap = new HashSet(list);
        System.out.println(hashMap);


    }
}
