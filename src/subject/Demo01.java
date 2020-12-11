package subject;

import java.util.Arrays;

/**
 * 统计一个大写的英文字符串中，各个字母出现的次数
 * 
 * @author zy
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		String str = "SDHFBAHSVXCVIASWWW";
		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			int c = str.charAt(i) - 'A';
			
			arr[c]++;
		}
		System.out.println(Arrays.toString(arr));
	}

}
