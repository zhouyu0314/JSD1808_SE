package allsort;

import java.util.Arrays;

/**
 * 1和0比 ，小于就交换
 * 2和1比，小于就交换，1和0比小于就交换。。。。。
 * 外循环length-1
 */
public class ZhiJieChaRu {


    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 5, 178, 8, 12, 18, 5, 2, 16, 48, 45, 4, 5804, 654, 44};
        int num1 = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {//如果后一个小于前一个
                    int k = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = k;
                } else {
                    break;
                }
                num1++;
                System.out.println(Arrays.toString(arr));

            }

        }
        System.out.println(num1);
        System.out.println("############" + num1 + "###################");


        int num2 = 0;
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 5, 178, 8, 12, 18, 5, 2, 16, 48, 45, 4, 5804, 654, 44};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
        //直接插入排序
        for (int i = 1; i < a.length; i++) {//循环length-1遍
            //待插入元素
            int temp = a[i]; //取出第二个值
            int j;
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的往后移动一位
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
                num2++;
                System.out.println(Arrays.toString(a));

            }
            a[j + 1] = temp;
        }
        System.out.println("############" + num2 + "###################");
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }


        int num3 = 0;
        int[] a1 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 5, 178, 8, 12, 18, 5, 2, 16, 48, 45, 4, 5804, 654, 44};
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1.length - 1; j++) {
                if (a1[j] > a1[j + 1]) {
                    int k = a1[j];
                    a1[j] = a1[j + 1];
                    a1[j + 1] = k;
                }
                num3++;
                System.out.println(Arrays.toString(a1));
            }
        }
        System.out.println("############" + num3 + "###################");


        int num4 = 0;
        int[] a2 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 5, 178, 8, 12, 18, 5, 2, 16, 48, 45, 4, 5804, 654, 44};
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
                if (a2[i] >= a2[middle]) {
                    //在右侧
                    //让left下标== middle
                    left = middle;
                } else {
                    right = middle;
                }
            }
            if (a2[i] < a2[left]) {
                //将组数从左下标开始，到i-1 往后复制
                System.arraycopy(a2, left, a2, right, i - left);
                a2[left] = temp;
                System.out.println(Arrays.toString(arr));
            } else {
                //将组数从左下标开始，到i-1 往后复制
                System.arraycopy(a2, right, a2, right + 1, i - right);
                arr[right] = temp;
                System.out.println(Arrays.toString(a2));
            }

            num4++;


        }
        System.out.println("############" + num4 + "###################");


    }


}
