package date;

import java.util.Date;

/**
 * java.util.Date
 * 日期类，其每一个实例用户表示一个确切的时间点。
 * Date内部维护一个long值，该值为自公元1970-01-01 00：00：00
 * 到其表示的时间之间所经过的毫秒。
 * 由于Date存在时区和千年虫问题，大部分操作时间的方法在JDK1.1版本
 * 出现时就变为过时方法，不再建议使用了。
 * @author zy
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		/*
		 * getTime可以获取Date内部
		 */
		long time = date.getTime();
		System.out.println(time);
		
		date.setTime(0);
		System.out.println(date);
	}
}
