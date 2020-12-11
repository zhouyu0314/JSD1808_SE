package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将一个字符串解析为Date
 * @author zy
 *
 */
public class SimpleDateFormat_parse {
	public static void main(String[] args) throws ParseException {
		String time = "2018/08/08 20:18:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = sdf.parse(time);
		System.out.println(date);
	}
}
