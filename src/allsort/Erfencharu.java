package allsort;

/**
 * 左下标0右下标就是遍历到的元素的下标，然后/2去中间，和中间比，如果比中间大则在右边，这时左边的下标应该改成原中间的下标，然后再
 * 取中间如此反复，一直到左右下标紧挨着。这时比较下该遍历的元素和左下标的大小关系，因为如果是开头第一个会出现意外
 * 然后通过数组复制的方式，将其插入指定位置   牺牲空间换取时间
 */

import java.util.Arrays;
import java.util.Random;

public class Erfencharu {
    public static void main(String[] args) {
        int num = new Random().nextInt();

        int[] arr  = new int[100000000];
        for (int i : arr) {
            i = num;
        }


        int[] arr1 = Arrays.copyOf(arr, arr.length);

        int[] a = Arrays.copyOf(arr, arr.length);


        long start = System.currentTimeMillis();
        System.out.println("****************牺牲空间换取时间*************************");
        //int[] arr = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
        for (int i = 1; i < arr.length; i++) {
            //确定左边下标
            //初始0
            int left = 0;
            //确定右边下标
            //初始i-1
            int right = i;
            //取出arr[i]值
            int temp = arr[i];
            //找到相邻的左右下标是退出循环
            while (left + 1 < right) {
                int middle = (right + left) / 2;
                if (arr[i] >= arr[middle]) {
                    //在右侧
                    //让left下标== middle
                    left = middle;
                } else {
                    right = middle;
                }
            }
            if(arr[i]<arr[left]){
                //将组数从左下标开始，到i-1 往后复制
                System.arraycopy(arr, left, arr, right, i-left);
                arr[left] = temp;
                //System.out.println(Arrays.toString(arr));
            }else{
                //将组数从左下标开始，到i-1 往后复制
                System.arraycopy(arr, right, arr, right + 1, i - right);
                arr[right] = temp;
                //System.out.println(Arrays.toString(arr));
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("1:"+(end-start)+0L);



        start = System.currentTimeMillis();
        System.out.println("****************牺牲时间换取空间*************************");
        //int[] arr1 = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
        for (int i = 1; i < arr1.length; i++) {
            //确定左边下标
            //初始0
            int left = 0;
            //确定右边下标
            //初始i-1
            int right = i;
            //取出arr[i]值
            int temp = arr1[i];
            //找到相邻的左右下标是退出循环
            while (left + 1 < right) {
                int middle = (right + left) / 2;
                if (arr1[i] >= arr1[middle]) {
                    //在右侧
                    //让left下标== middle
                    left = middle;
                } else {
                    right = middle;
                }
            }
            if(arr1[i]<arr1[left]){
                for (int j = i; j > left; j--) {
                    arr1[j] = arr1[j-1];
                }
                arr1[left] = temp;
                //System.out.println(Arrays.toString(arr1));
            }else{
                for (int j = i; j > right; j--) {
                    arr1[j] = arr1[j-1];
                }
                arr1[right] = temp;
                //System.out.println(Arrays.toString(arr1));

            }

        }
        end = System.currentTimeMillis();
        System.out.println("2:"+(end-start)+0L);















        start = System.currentTimeMillis();
        System.out.println("*****************网上的代码*************************");
        //int[] a = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                if(temp<a[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            for (int j = i-1; j >= left; j--) {
                a[j+1] = a[j];
            }
            if(left != i){
                a[left] = temp;
            }
            //System.out.println(Arrays.toString(a));
        }

        end = System.currentTimeMillis();
        System.out.println("3:"+(end-start)+0L);
    }



    }

