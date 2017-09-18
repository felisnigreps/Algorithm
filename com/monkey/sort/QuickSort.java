package com.monkey.sort;

import java.util.LinkedList;

public class QuickSort {
    public static void rec_quickSort(int[] a, int start, int end) {
        int index = 0;
        if (start < end) {
            index = partition(a, start, end);
            rec_quickSort(a, start, index - 1);
            rec_quickSort(a, index + 1, end);
        }
    }

    private static void nonRec_quickSort(int[] a, int start, int end) {
        LinkedList<Integer> stack = new LinkedList<Integer>();  //用栈模拟
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(a, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }

    //快排分割算法
    public static int partition(int[] a, int start, int end) {
        //选择开始为基准点
        int pivot = a[start];
        while (start < end) {
            while (start < end && a[end] >= pivot) {
                end--;
            }
            //把右侧第1个小于pivot的值赋到左1
            //左1值存储到了pivot中
            a[start] = a[end];
            while (start < end && a[start] <= pivot) {
                start++;
            }
            //把左侧第1个大于pivot的值赋到右侧
            a[end] = a[start];
        }
        //最后再还原pivot值
        a[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 1, 4, 3, 5, 12, 34, 55, 6, 22, 3, 12, 42, 45, 67, 33, 22, 32};
        // rec_quickSort(arr,0,arr.length-1);
        nonRec_quickSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }

    }
}
