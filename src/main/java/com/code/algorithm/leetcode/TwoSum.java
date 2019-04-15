package com.code.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        // int[] nums = { 2, 7, 11, 15 };
        // int[] nums = { 3, 3 };
        //        int[] nums = { 2, 5, 5, 11 };
        int[] nums = { 3, 2, 4 };
        System.out.println(Arrays.toString(twoSum(nums, 10)));

        System.out.println(Arrays.toString(twoSum3(nums, 10)));

    }

    public static int[] twoSum2(int[] nums1, int m) {
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[2];
        for (int t : nums1) {
            if (set.contains(m - t)) {
                result[0] = t;
                result[1] = m - t;
                break;
            }
        }
        return result;
    }

    public static int[] twoSum3(int[] nums, int m) {
        int[] result = new int[2];
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);
        while (i < j) {
            int tmp = nums[i] + nums[j];
            if (tmp == m) {
                result[0] = i;
                result[1] = j;
                return result;
            }
            if (tmp < m) {
                i++;
            }
            if (tmp > m) {
                j--;
            }
        }
        return result;
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

    public static int[] fourSum(int[] nums, int target) {
        int[] temp = new int[4];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int ii = target - i;

        }
        return temp;
    }
}
