package subject;

import java.util.Arrays;
import java.util.Random;

/**
 * 从1000000个数据中找到前100大的数据
 * @author zy
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		Random rand = new Random();
		long[] arr = new long[100];
		long n = 0;
		for (int i = 0; i < 1000000; i++) {
			n = rand.nextLong();
			int index = Arrays.binarySearch(arr, n);
			index = index<0?-(index+1):index;
			if(index == 0) continue;
			for(int j = 0;j<index-1;j++){
				arr[j] = arr[j+1];
			}
			
			arr[index-1] = n;
		}
		
		for(long num:arr){
			System.out.println(num);
		}
		
		
	}

}
