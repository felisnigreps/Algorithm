package com.monkey.leetCode;

/**
 * Created by xugenli on 2017/7/5.
 */
public class ReverseWords {
    public static void main(String[] args) {
        String verse = "Let's take LeetCode contest";
        String[] split = verse.split(" ");
        String result ="";
        for(int i=0;i<split.length;i++){
            result = result + reverse(split[i])+" ";
        }
        result = result.substring(0,result.length()-1);
        System.out.println(result);

    }

    public static String reverse(String s){
        StringBuffer cac = new StringBuffer(s);
        String result = cac.reverse().toString();
        return result;

    }



}
