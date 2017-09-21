package com.monkey.leetCode;

import java.util.Arrays;

public class CountPrime {
    //直观但是比较笨的方法 会超时
/*    public int count(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }*/

    /*埃氏筛法
        如果一个数是另一个数的倍数，那这个数肯定不是素数。利用这个性质，我们可以建立一个素数数组，
        从2开始将素数的倍数都标注为不是素数。第一轮将4、6、8等表为非素数，然后遍历到3，发现3没有被标记为非素数，
        则将6、9、12等标记为非素数，一直到N为止，再数一遍素数数组中有多少素数。
    */
    public int count(int n) {
        int count = 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                //2倍 3倍 4倍 等等
                for (int j = i * 2; j < n; j = j + i) {
                    primes[j] = false;
                }
            }
        }
    //不能使用foreach 因为0和1都是true
        for (int i = 2; i < n; i++) {
            if (primes[i]) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        CountPrime a = new CountPrime();
        System.out.println(a.count(6));
    }
}
