package subject;

import java.util.Arrays;

/**
 * 冒泡排序
 * 
 * @author zy
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		int[] arr = {4,1,2,74,56,14,51,1,2,6,7,4,5,3};
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[i]<arr[j]+1){
					int k = arr[i];
					arr[i] = arr[j];
					arr[j] = k;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
