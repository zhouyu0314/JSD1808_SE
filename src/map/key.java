package map;
/**
 * HashMap内部使用一个数组来保存元素，但是散列表是根据
 * key元素的hashcode值直接计算出其在数组的下标位置，这
 * 样就避免了查询过程中遍历数组这样的操作，所以查询效率
 * 不受数组数据量的多少而变化。
 * 
 * hashcode方法是Object定义的方法，意味着所有的类都具有
 * 该方法。
 * 
 * 在HashMap的使用中存在一种情况，当两个key的hashcode值
 * 相同（意味着他们在HashMap内部数据保存时的下标相同），但
 * equals比较不同时（HashMap认为他们是不重复的key）那么就
 * 会在HashMap内部的数组对应位置处出现一个链表，来保存这
 * 两组键值对。
 * 由于链表的缺点是遍历速度慢，因此，在HashMap中出现链表会
 * 影响查询性能。
 * 
 * Object提供的两个方法已经妥善处理了上述问题，但是有时我们定义
 * 的类会去重写equals方法，API文档中Object对这两个方法的
 * 解释明确说明了上述问题，因此重写时要遵守一下原则：
 * 1：成对重写，即：当我们重写一个类的equals方法时就应当
 * 连同重写hashCode
 * 2：一致性，当两个对象的equals比较为true时，hashCode方法
 * 返回的数字必须相等。反过来虽然不是必须的，但是尽量保证当两个对象
 * hashCode值相同时equals比较也为true，否则会在hashMap
 * 使用中作为key存在时形成链表，影响查询性能。
 * 3：稳定性，当一个对象中参与equals方法比较的属性值没有发生变化的
 * 前提下多次调用hashCode方法返回的数字应当不变。
 * @author zy
 *
 */

public class key {
	private int x;
	private int y;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		key other = (key) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
