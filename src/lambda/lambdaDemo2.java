package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 有参数的方法
 * @author zy
 *
 */
public class lambdaDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("周杰");
		list.add("周杰伦");
		list.add("蔡徐坤");
		list.add("一");
		list.add("张三");
		list.add("李四");
		list.add("诸葛孔明");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
//		Comparator<String> c = new Comparator<String>(){
//			public int compare(String o1, String o2) {
//				return o1.length()-o2.length();
//			}	
//		};
//		Collections.sort(list,(o1,o2)->{
//			return o1.length()-o2.length();
//		});
		/*
		 * 如果方法只有一句代码，那么在删除"{}"同时，
		 * 若方法要求返回值时，"return"关键字也必须省略
		 */
		Collections.sort(list,(o1,o2)->
		o1.length()-o2.length()
	);
		System.out.println(list);
	}
}
