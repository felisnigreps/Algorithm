package com.monkey.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xugenli on 2017/7/14.
 */
public class DistributeCandies {
    public static void main(String[] args) {
        int[] candies = {1,1,2,2,3,3,4,5,6,6,7,7,7,7,8,8,9,11,11,13,15,15};
        System.out.println("长度:"+candies.length);
        removeDuplicate(candies);
    }

    public static int removeDuplicate(int[] candies) {
        Set container = new HashSet();
        for(int i:candies){
            container.add(i);
        }
        System.out.println(container);
        System.out.println(container.size());
        int a = candies.length/2;
        int b = container.size();
        int len = a>b?b:a;
        System.out.println(len);
        return len;
    }
}
