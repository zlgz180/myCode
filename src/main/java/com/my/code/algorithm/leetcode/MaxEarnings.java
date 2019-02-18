package com.my.code.algorithm.leetcode;

import java.util.Arrays;

/**
 * 
 */
public class MaxEarnings {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(maxEarnings(nums)));
    }

    /**
     * 求数组最大差
     * 
     * @param nums
     * @return
     */
    public static int[] maxEarnings(int[] nums) {
        int[] result = new int[2];

        int sum = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int tmp = nums[j] - nums[i];
                if (tmp > 0 && tmp > sum) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                    sum = tmp;
                }
            }
        }
        return result;
    }
}
