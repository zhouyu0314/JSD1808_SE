package date;

import java.util.Calendar;

/**
 * Calendar提供了获取指定时间分量对应值的操作：
 * int get(int field)
 * 参数为对应的时间分量，返回值为该时间分量所对应的值。
 * 而时间分量Calendar提供了大量的常量来表示。
 * @author zy
 *
 */
public class Calendar_get {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * 获取日和"天"相关的时间分量：
		 * DAY_OF_MONTH:月中的天（DATE）
		 * DAY_OF_WEEK:周中的天
		 * DAY_OF_YEAR:年中的天
		 */
		System.out.println(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH));
		
		//获取时分秒
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
		//今天是今年的第几天？
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
		//今天是周几
		String[] date = {"日","一","二","三","四","五","六"};
		System.out.println(date[calendar.get(Calendar.DAY_OF_WEEK)-1]);
		//今年一共多少天？
		System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		//当月一共多少天？
		System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
}
