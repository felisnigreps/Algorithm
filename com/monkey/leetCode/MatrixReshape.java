package com.monkey.leetCode;

/**
 * Created by xugenli on 2017/7/12.
 */
public class MatrixReshape {
    public int[][] solution(int[][] nums, int r, int c) {
        int[][] result = new int[r][c];
        int n = nums[0].length;
        System.out.println(r * c);
        if (r * c != nums.length * nums[0].length) {
            return nums;
        } else {
            for (int i = 0; i < r * c; i++) {
                result[i / c][i % c] = nums[i / n][i % n];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MatrixReshape a = new MatrixReshape();
        int[][] nums = {{1, 2}, {3, 4}};
        a.solution(nums, 1, 4);
    }


}
