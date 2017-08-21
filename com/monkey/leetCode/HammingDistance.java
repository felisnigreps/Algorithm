package com.monkey.leetCode;

/**
 * Created by xugenli on 2017/6/26.
 */
public class HammingDistance {


    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        int z = x ^ y;
        int result = 0;
        //使用 >> 来判断
        for (int i = 0; i < 32; i++) {
            result += (z >> i) & 1;
        }

        System.out.println("---" + result);


    }
}
