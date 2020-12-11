package subject;


/**
 * 解析7进制123
 * 
 * @author zy
 *
 */
public class Demo02 {

	public static void main(String[] args) {
		int weight = 1;
		String str = "123";
		int num = 7;
		int sum = 0;
		for (int i = str.length()-1; i >=0; i--) {
			sum += (str.charAt(i)-'0')*weight;
			weight *= 7;
		}
		
		System.out.println(sum);
	}
}
