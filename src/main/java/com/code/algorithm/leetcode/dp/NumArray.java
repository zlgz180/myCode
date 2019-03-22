package com.code.algorithm.leetcode.dp;

/**
 * 给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 说明:
 *
 * 你可以假设数组不可变。 会多次调用 sumRange 方法。
 *
 * @author tianwei
 * @since 2019-03-04 11:12
 */
public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        this.sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] += sums[i] + sums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return (i == 0) ? sums[0] : (sums[j] - sums[i - 1]);
    }
}
