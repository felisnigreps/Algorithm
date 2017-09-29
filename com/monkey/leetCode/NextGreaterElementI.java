package com.monkey.leetCode;

public class NextGreaterElementI {
    public static int[] solution(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = getNumber(nums1[i], nums2);
        }
        return result;
    }

    public static int getNumber(int num, int[] source) {
        for (int i = 0; i < source.length; i++) {
            if (num == source[i]) {
                for (int j = i; j < source.length; j++) {
                    if (source[j] > num) {
                        return source[j];
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        for(int r:solution(nums1,nums2)){
            System.out.println(r);
        }

    }
}
