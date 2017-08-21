package com.monkey.leetCode;

/**
 * Created by xugenli on 2017/7/5.
 */
public class CountBits {
    public static void main(String[] args) {
        for (int a : countBits(5)) {
            System.out.println(a);
        }

    }

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        //初始化的时候每一位都是0,所以res[0]=0
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
