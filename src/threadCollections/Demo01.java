package threadCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 线程安全的集合
 */
public class Demo01 {
    public static void main(String[] args) {

        List<Integer> integers = Collections.synchronizedList(new ArrayList<Integer>());
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        CopyOnWriteArraySet<Object> objects = new CopyOnWriteArraySet<>();
    }
}
