package com.monkey.leetCode;

public class JudgeCircle {
    public boolean result(String moves) {
        //只要UD和LR成对出现就return true
        //这种写法让我对数组有了更多的认识
        char[] count = new char[128];
        for (char i : moves.toCharArray()) {
            count[i]++;
        }
        System.out.println(count['L']);
        //count['L']就是count[76], 会自动转换 依次类推
        // System.out.println(Integer.valueOf('L'));
        return count['U'] == count['D'] && count['L'] == count['R'];
    }

    public static void main(String[] args) {
        JudgeCircle a = new JudgeCircle();
        System.out.println(a.result("LDRRLRUULR"));
    }
}
