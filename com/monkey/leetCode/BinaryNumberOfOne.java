package com.monkey.leetCode;

public class BinaryNumberOfOne {
    //求二进制中1的个数
    //总结：把一个整数减去1，再和原整数做与运算，会把该整数最右边1一个1变成0。
    //那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。从而可以减少比较的次数。
    public static void main(String[] args) {
        int 数字 = 47;
        int count = 0;
        while (数字 != 0) {
            count++;
            数字 = 数字 & (数字 - 1);
        }
        System.out.println(count);
    }
}
