package com.monkey.leetCode;

public class ReverseString {
    //用StringBuffer的reverse当然没问题 不过就失去这个题目的精髓了
    //我们倒是可以看看 reverse()方法怎么写的
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<j){
            arr[i] = s.charAt(j);
            arr[j] = s.charAt(i);;
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        ReverseString a = new ReverseString();
        System.out.println(a.reverseString("abcdef"));
    }
}
