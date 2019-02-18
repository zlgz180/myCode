package com.my.code.algorithm.leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        // int[] nums = { 2, 7, 11, 15 };
        // int[] nums = { 3, 3 };
        int[] nums = { 2, 5, 5, 11 };
        System.out.println(Arrays.toString(twoSum(nums, 10)));



    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    temp[0] = i;
                    temp[1] = j;
                    return temp;
                }
            }
        }
        return temp;
    }
}
