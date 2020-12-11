package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 程序启动后，要求用户输入自己的生日，格式：yyyy-MM-dd
 * 然后经过程序计算，输出到今天为止一共活了多少天？
 * 以及出生10000天的纪念日时哪天，纪念日格式同上。
 * @author zy
 *
 */
public class Test {
	public static void main(String[] args) throws ParseException {
		String birth = "1992-03-14";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(birth);
		Date now = new Date();
		long timeNow = now.getTime();
		Long time = date.getTime();
		System.out.println("活了:"+(timeNow-time)/1000/60/60/24);
		Date date1 = new Date(time+10000L*24*60*60*1000);
		System.out.println("10000纪念日:"+sdf.format(date1));
		
	}
}
