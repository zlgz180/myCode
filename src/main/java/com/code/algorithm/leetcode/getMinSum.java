package com.code.algorithm.leetcode;

import java.util.Collections;

/**
 * 有一个无序int数组，没有重复元素，求出把数组分成三份的两个数最小的和。举例： 1、2、3、4、5、6，最小和是2 + 4 = 6，时间复杂度O(n)。
 */
public class getMinSum {
    public static void main(String[] args) {
        // int[] nums = { 2, 7, 11, 15 };
        // int[] nums = { 3, 3 };
        // int[] nums = {1, 2, 3, 4, 5, 6};
        // System.out.println(Arrays.toString(twoSum(nums)));

        int[] nums = { 0, 2, -1, 4, 3, 5, 8, -3 };
        System.out.println(getMinSum(nums));
    }

    private static long getMinSum(int arr[]) {
        if (arr == null || arr.length < 5) {
            return -1; // or throw npe
        }
        int leftIndex = 1, rightIndex = arr.length - 2;
        long leftMin = arr[leftIndex], rightMin = arr[rightIndex];

        while (leftIndex + 2 < rightIndex) {
            if (leftMin < rightMin) {
                rightMin = Math.min(rightMin, arr[--rightIndex]);
            } else {
                leftMin = Math.min(leftMin, arr[++leftIndex]);
            }
        }

        return leftMin + rightMin;
    }

    public static int[] twoSum(int[] nums) {
        int[] temp = new int[2];
        if (nums == null || nums.length <= 2) {
            return temp;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[i] + nums[j] < min) {
                    temp[0] = nums[i];
                    temp[1] = nums[j];
                    return temp;
                }
            }
        }
        return temp;
    }
}
