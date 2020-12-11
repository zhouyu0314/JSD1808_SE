package string;
/**
 * 由于String的设计不适合频繁修改，对此java提供了一个
 * 用于编辑字符串内容的类:StringBuilder
 * StringBuilder内部维护了一个可变的字符数组，不会每次
 * 修改都来创建新对象，从而降低资源开销，提高执行效率。
 * 其提供了方便编辑字符串内容的相关方法，包含:
 * 增，删，改，插等常见操作。
 * @author ta
 *
 */
public class StringBuilderDemo {
	public static void main(String[] args) {
		String str = "好好学习java";
		/*
		 * 常见构造方法：
		 * StringBuilder():无参，默认表示空字符串
		 * StringBuilder(String str):表示给定内容
		 */
		StringBuilder builder = new StringBuilder(str);
		
		/*
		 * 好好学习java
		 * 好好学习java,为了找个好工作!
		 * 
		 * append():向当前字符串末尾追加给定内容
		 */
		builder.append(",为了找个好工作!");
		//获取builder内部编辑后的字符串
		String s = builder.toString();
		System.out.println(s);
		
		/*
		 * 好好学习java,为了找个好工作!
		 * 好好学习java,就是为了改变世界!
		 * 
		 * replace():替换指定范围内的字符串
		 */
		builder.replace(9, 16, "就是为了改变世界");
		System.out.println(builder);
		
		/*
		 * 好好学习java,就是为了改变世界!
		 * ,就是为了改变世界!
		 * 
		 * delete():删除指定范围内的字符串
		 */
		builder.delete(0, 8);
		System.out.println(builder);
		
		/*
		 * ,就是为了改变世界!
		 * 活着,就是为了改变世界!
		 * 
		 * insert():在当前字符串中插入指定内容
		 */
		builder.insert(0, "活着");
		System.out.println(builder);
	}
}









