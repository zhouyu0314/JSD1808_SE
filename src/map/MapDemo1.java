package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map
 * Map 查找表，结构看起来像是一个多行两列的表格。
 * 左列称为key，右列称为value。
 * 所以Map总是以key-value对的形式保存元素。
 * 并且总是根据key去获取对应的value。
 * 对此我们经常将"查询条件"作为key，将要查询的
 * 数据作为value进行保存。
 * 
 * Map本身是一个接口，规定了Map操作的相关方法。
 * 常用实现类：java.util.HashMap
 * 
 * HashMap又称为散列表、哈希表
 * 使用散列算法实现的Map，当今世界上查询速度最快的
 * 数据结构。
 * @author zy
 *
 */

public class MapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		/*
		 * V put(K k,V v)
		 * 将给定的一组键值对存入到Map中
		 * 
		 * Map有一个要求，即：key不允许重复，
		 * 是否重复是依靠key自身的equals比较的结果。
		 * 如果使用map中已有的key保存value，
		 * 则这个操作作为替换value操作，那么这是put方法
		 * 将被替换的value返回。
		 * 否则返回值为null。
		 */
		/*
		 * 如果value是一个包装类，那么接收时应当避免直接用基本类型。
		 * 因为这会导致自动拆箱，若没有替换操作，返回的value为null时
		 * 就引发了空指针异常。
		 */
		Integer d = map.put("语文",98);
		map.put("数学",97);
		map.put("英语",96);
		map.put("物理",95);
		map.put("化学",98);
		System.out.println(d);
		System.out.println(map);
		d = map.put("语文", 55);
		System.out.println(d);
		System.out.println(map);
		/*
		 * V get（Object key）
		 * 根据给定的key获取对应的value，若给定的key不存在，
		 * 则返回值为null
		 */
		d = map.get("语文");
		System.out.println(d);
		d = map.get("体育");
		System.out.println(d);
		/*
		 * int size()
		 * 获取Map中的元素个数，每组键值对算一个元素
		 */
		int size = map.size();
		System.out.println(size);
		
		/*
		 * V remove(K k)
		 * 将给定的key所对应的键值对删除。
		 * 返回值为该key对应的value。
		 */
		d = map.remove("语文");
		System.out.println(d);
		
		
		
		
		
		
		
		
		
	}
}
