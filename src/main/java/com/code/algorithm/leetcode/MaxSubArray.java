package com.code.algorithm.leetcode;

/**
 * @author tianwei
 * @since 2019-02-21 17:34
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] sums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(sums));
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例: 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6
     * <p>
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int result = 0;
        int sum = nums[0];
        for (int num : nums) {
            //如果小于0就不加了，加了就小了
            if (sum < 0) {
                sum = num;
            } else {
                sum = sum + num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
