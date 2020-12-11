package socket;

import java.util.Arrays;

/**
 * 从数组中删除给定元素
 * @author zy
 *
 */

public class Demo {


	public static void main(String[] args) {
		int[] allOut = {1,2,3,4,5,6,7,8,9,0};
		int pw = 3;
		//将该pw从数组中删除
		for(int i=0;i<allOut.length;i++){
			if(pw==allOut[i]){
				//将其与最后一个元素交换
				allOut[i] = allOut[allOut.length-1];
				break;
			}
		}
		//缩容
		allOut = Arrays.copyOf(allOut, allOut.length-1);
		System.out.println(Arrays.toString(allOut));


				
				
	}

}
