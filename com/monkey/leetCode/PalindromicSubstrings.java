package com.monkey.leetCode;

public class PalindromicSubstrings {
    int count = 0;

    public int countSubstrings(String s) {
        //回文字符串就是从左到右 and 从右到左读起来是一致的
        //单个字符肯定是回文字符串
        //回文字符串分为两种 奇数和偶数
        //从中间开始（技术为1,偶数为2）两个指针开始移动 如果相等，那么就确定是回文字符串
        //需要把每个字符串i作为基点（偶数为i,i+1）
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            calculate(s, i, i);
            calculate(s, i, i + 1);
        }
        return count;
    }

    public void calculate(String s, int left, int right) {
        //什么时候是回文字符串呢？
        //设置退出条件
        //O(n^2) 最坏情况两层循环
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
