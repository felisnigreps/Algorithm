package com.monkey.leetCode;

/**
 * Created by xugenli on 2017/7/4.
 */
public class NumberComplement {
    public static void main(String[] args) {
        //1毫秒(ms)=1000000纳秒(ns)
        long startTime = System.nanoTime();   //获取开始时间

        calculate(); //测试的代码段

        long endTime = System.nanoTime(); //获取结束时间

        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }

    public static void calculate() {
        int num =5;
        //1807501ns
//        String b = Integer.toBinaryString(num);
//        String c = b.replace("1","2").replace("0","1").replace("2","0");
//        System.out.println(Integer.valueOf(c,2)) ;
        //267244ns
        int mask = (Integer.highestOneBit(num)<<1)-1;
        System.out.println(mask^num);

    }
}
