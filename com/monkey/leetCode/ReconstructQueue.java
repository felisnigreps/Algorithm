package com.monkey.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {
    public static int[][] solution(int[][] people) {
        //先比第一个 从大到小,如果相等,那么按照第二位从小到大
        //然后根据第二位的大小来进行插入 注意不能越界,list.add 如果index相同则插到前面
        //感觉很难啊 理解都需要好一阵 自己写出来目前十分困难
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList();
        for(int[] p:people){
            list.add(p[1],p);
        }
        int[][] result = list.toArray(new int[list.size()][]);
        return result;

    }

    public static void main(String[] args) {
        int[][] arr = new int[6][2];
        arr[0] = new int[]{7, 0};
        arr[1] = new int[]{4, 4};
        arr[2] = new int[]{7, 1};
        arr[3] = new int[]{5, 0};
        arr[4] = new int[]{6, 1};
        arr[5] = new int[]{5, 2};
        System.out.println(solution(arr));





    }
}
