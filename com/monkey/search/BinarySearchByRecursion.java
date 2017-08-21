package com.monkey.search;

/**
 * Created by xugenli on 2017/2/19.
 */
public class BinarySearchByRecursion {
    //二分查找 递归方式
    public static void doSearch(int[] arr, int target, int begin, int end) {
        if (begin <= end) {
            //右移一位 相当于/2
            int mid = (begin + end) >> 1;
            if (target == arr[mid]) {
                System.out.println(mid);
            } else if (target < arr[mid]) {
                doSearch(arr, target, begin, mid-1);
            } else {
                doSearch(arr, target, mid+1, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 9, 12};
        int target = 7;
        doSearch(arr, target, 0, arr.length - 1);
    }
}
