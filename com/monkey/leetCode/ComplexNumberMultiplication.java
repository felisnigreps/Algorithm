package com.monkey.leetCode;

/**
 * Created by xugenli on 2017/7/3.
 */
public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        String a = "-1-i";
        String b = "8-i";
        System.out.println(calculate(a, b));
    }

    //把一个String分解成两部分 a+bi,去掉i
    public static String[] formatComplexNumber(String ComplexNumber) {
        //这里没有做校验,先假设输入都是正确的
        //首先吧+-换成-,这样只剩下单一存算符号
        String a = ComplexNumber.replace("+-", "-");
        //分割a,b位 从后往前开始,遇到的第一个符号为运算符
        int aIndex = a.lastIndexOf('+') == -1 ? a.lastIndexOf('-') : a.lastIndexOf('+');
        String a1 = a.substring(0, aIndex);
        String a2;
        //对截取时对i特殊处理,可以实部为-
        String imaginaryPart = a.substring(aIndex, a.length() - 1);
        if (imaginaryPart.equals("+")) {
            a2 = "1";
        } else if (imaginaryPart.equals("-")) {
            a2 = "-1";
        } else {
            a2 = imaginaryPart;
        }
        String[] result = {a1, a2};
        return result;
    }

    public static String calculate(String a, String b) {
        int a1 = Integer.parseInt(formatComplexNumber(a)[0]);
        int a2 = Integer.parseInt(formatComplexNumber(a)[1]);
        int b1 = Integer.parseInt(formatComplexNumber(b)[0]);
        int b2 = Integer.parseInt(formatComplexNumber(b)[1]);
        //结果分为2个部分,实部和虚部
        String realPart = (a1 * b1 - a2 * b2) + "";
        String imaginaryPart = (a1 * b2 + b1 * a2) + "i";
        String result = realPart + "+" + imaginaryPart;
        return result;
    }
}
