package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断Map是否包含给定元素。
 * 可以分别判断是否包含key和value
 * boolean containsKey（Object k）
 * boolean containsValue(Object v)
 * @author zy
 *
 */

public class MapDemo3 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("语文",98);
		map.put("数学",97);
		map.put("英语",96);
		map.put("物理",95);
		map.put("化学",98);
		System.out.println(map);
		/*
		 * 查看是否包含指定的key
		 */
		boolean ck = map.containsKey("数学");
		System.out.println(ck);
		boolean cv = map.containsValue(95);
		System.out.println(cv);
	}
}
