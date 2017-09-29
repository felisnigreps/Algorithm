package com.monkey.leetCode;

import java.util.*;

public class FindDuplicates {
    public static List<Integer> solution(int[] nums) {
        //解法比较有趣:
        //当我们找到一个数值的时候,把他减1当做index,如果两个数相等,那么他们找到的index也一定一样
        //我们把找到的index上的数值做一个标记,当我们发现一个新的index上已经有标记的时候
        //我们就知道,他被标记过了,就证明当前我的数值出现过两次,取消标记加入到list中
        //在这里我们取相反数 因为取值范围>=1
        List result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            //如果被标记过 那么加入list
            if (nums[index] < 0) result.add(Math.abs(nums[i]));
            //如果没被标记过 那么标记
            nums[index] = -nums[index];
        }
        return result;
    }

    //这个方法也很巧妙呀
    public static List<Integer> solution1(int[] nums) {
        List result = new ArrayList();
        int[] cache = new int[100];
        for (int i = 0; i < nums.length; i++) {
            cache[nums[i]]++;
        }
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == 2) result.add(i);
        }
        return result;
    }


    public static void main(String[] args) {
        int nums[] = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        //System.out.println(solution(nums));

        System.out.println(solution1(nums));
    }
}
