package com.monkey.search;

/**
 * Created by xugenli on 2017/2/19.
 */
public class BinarySearch {
    //二分查找 非递归方式
    public static int doSearch(int[] arr, int target) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin <= end) {
            int mid = (begin + end) >> 1;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 9, 12};
        int target = 7;
        System.out.println(doSearch(arr, target));
    }
}