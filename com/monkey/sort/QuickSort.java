package com.monkey.sort;

/**
 * Created by xugenli on 2017/2/19.
 */
public class QuickSort {
    //相对来说比较快的排序  O(n^logn) 大部分情况下是最好的解决办法 如果已经是几乎有序 那么效率和冒泡差不多
    //选取一个基准值 为的是第一次排序后 左侧都比基准值小 右侧都比基准值大
    public static void doSort(int[] a, int low, int high) {
        //选取第一个做基准值 注意基准值在排序右半侧的时候会变 所以要写a[low]
        int key = a[low];
        //左侧指针
        int start = low;
        //右侧指针
        int end = high;
        //开始循环 直到指针相遇 递归
        //等下进行优化.if判断
        while (start < end) {
            //从后方开始循环 如果大于key就往前挪动指针 直到找到小于key的值
            //while中还存在start<end的原因是函数内部有end--,不然会报出越界异常
            while (start < end && a[end] >= key) {
                end--;
            }
            //如果比key小,那么就换位置
            int temp = key;
            key = a[end];
            a[end] = temp;
            //然后从另一端开始比较
            while (start < end && a[start] <= key) {
                start++;
            }
            temp = key;
            key = a[start];
            a[start] = temp;
        }
        //开始递归
        //避免栈溢出 设置判断条件
        if (start > low) {
            doSort(a, low, start - 1);
        }
        if (end < high) {
            doSort(a, end + 1, high);
        }


    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 1, 4, 3, 5, 12, 34, 55, 6, 22, 3, 12, 42, 45, 67, 33, 22, 32};
        doSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + "_");
        }
    }
}

