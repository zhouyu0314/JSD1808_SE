package allsort;


import java.util.Scanner;

/**
 * 求123 全排列
 */
public class Demo01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        int a[] = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        long startTime = System.currentTimeMillis();
        arrange(a, 0, a.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间:" + (endTime - startTime) + "ms");
    }
    static void arrange(int a[], int start, int end) {

        if (start == end) {//开始和结束相等结束递归
            for (int i : a) {//对数组a进行遍历
                System.out.print(i);//不换行输出数组
            }
            System.out.println();//换行
            return;
        }
        //如果开始和结束不相等
        for (int i = start; i <= end; i++) {//循环结束遍
            swap(a, i, start);//
            arrange(a, start + 1, end);
            swap(a, i, start);
        }
    }

    static void swap(int arr[], int i, int j) {//数组0和1交换
        int te = arr[i];
        arr[i] = arr[j];
        arr[j] = te;
    }
}


