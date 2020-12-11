package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 集合工具类
 * Collections.addAll(集合,值,值....);一次全添加
 * sort() 排序
 * Collections.binarySearch(集合,目标值);二分查找
 * Collections.swap(集合,下标,下标);交换
 *
 */
public class CollectionDemo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list,"11","1","4","12","2","30");
        System.out.println(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o2)-Integer.valueOf(o1);
            }
        });
        System.out.println(list);
    }
}
