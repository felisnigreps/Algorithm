package com.monkey.sort;

/**
 * Created by xugenli on 2017/2/19.
 */
public class BubbleSort {
    //冒泡排序 最基础的排序 但是非常慢 O(N^2)
    public static void doSort(int arr[]) {
        int temp;
        //两层循环 前面和后面比 小的就往前放
        //从尾部到顶部循环理解起来貌似容易一些
        for(int i=arr.length-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                if(arr[i]<arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 7, 3, 9, 12, 24, 6};
        doSort(arr);
        for (int a : arr) {
            System.out.println(a);

        }
    }

}
