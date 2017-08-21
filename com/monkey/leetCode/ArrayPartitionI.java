package com.monkey.leetCode;

import java.util.Arrays;

/**
 * Created by xugenli on 2017/6/28.
 */
public class ArrayPartitionI {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5, 6, 12, 5};
        //this sort is a Dual-Pivot Quicksort
        Arrays.sort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
        int res = 0;
        for (int i = 0; i < arr.length; i = i + 2) {
            res += arr[i];
        }
        System.out.println(res);
        System.out.println(1/4);

    }
}
