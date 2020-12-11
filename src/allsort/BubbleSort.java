package allsort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {10,5,8,1,32,4,121,80};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j]>arr[j+1]) {
                    int k = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = k;
                }


            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
