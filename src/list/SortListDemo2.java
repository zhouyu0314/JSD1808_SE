package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序字符串
 * @author zy
 *
 */

public class SortListDemo2 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("tom");
		l.add("jerry");
		l.add("JACK");
		l.add("TOMAS");
		l.add("MIKE");
		l.add("bill");
		l.add("jackson");
		l.add("michell");
		System.out.println(l);
		/*
		 * 字符串比较大小哦的规则是按照首字符的unicode编码比较，
		 * 若第一个字符一样则看第二个，以此类推。
		 */
		Collections.sort(l);
		System.out.println(l);
	}

}
