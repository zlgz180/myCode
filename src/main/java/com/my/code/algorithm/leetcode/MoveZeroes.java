package com.my.code.algorithm.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
 */
public class MoveZeroes {
    public static void main(String[] args) {
        // int[] nums = { 0, 1, 4, 3, 12 };
        int[] nums = { 0, 0, 1, 4, 3, 12 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int zeroIndex = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != 0 && nums[j] == 0) {
                    break;
                }
                if (nums[i] == 0 && nums[j] != 0) {
                    // 有连续0的情况,直接把非0的数和第一个0互换
                    if (zeroIndex >= 0) {
                        int tmp = nums[j];
                        nums[j] = nums[zeroIndex];
                        nums[zeroIndex] = tmp;
                        break;
                    }
                    // 普通没有连续0的情况，
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    break;
                }
                // 如果0连续
                if (nums[i] == 0 && nums[j] == 0) {
                    zeroIndex = i;
                }
            }
        }
    }
}
