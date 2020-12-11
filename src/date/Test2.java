package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 计算商品的促销日期
 * 输入一个商品的生产日期，格式为:yyyy-MM-dd
 * 再输入该商品的保质期天数
 * 然后经过程序计算输出该商品的促销日期，格式同上
 * 
 * 促销日期计算规则:该商品过期日前两周的周三。
 * @author zy
 *
 */
public class Test2 {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("请输入商品的生产日期（格式为:yyyy-MM-dd）：");
			String productionDate = scan.nextLine();
			System.out.println("请输入商品的保质期：");
			int shelfLife = Integer.parseInt(scan.nextLine());
			if(productionDate.matches("\\d{4}-\\d{2}-\\d{2}")){
				String[] date = productionDate.split("-");
				Calendar calendar = Calendar.getInstance();
				calendar.set(Integer.parseInt(date[0]),(Integer.parseInt(date[1])-1),Integer.parseInt(date[2]));
				calendar.add(Calendar.DAY_OF_YEAR, shelfLife);
				calendar.add(Calendar.WEEK_OF_YEAR, -2);
				calendar.set(Calendar.DAY_OF_WEEK, 4);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println("促销日期："+sdf.format(calendar.getTime()));
				break;
			}else{
				System.out.print("输入格式错误！");
			}
			
		}

	}
}
