package com.my.code.algorithm.leetcode;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3] 输出: 3 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2] 输出: 2
 * 
 * @author tianwei
 * @since 2019-02-20 18:19
 */
public class MajorityElement {
    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 4, 5, 1, 6 };
        // System.out.println(majorityElement(nums));
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count++;
            } else if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int flag = 0;
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                if (++flag > 1) {
                    del(nums, i + 1);
                    if (nums.length - 1 == i + sum) {
                        break;
                    }
                    // 删除之后序号变小了
                    i--;
                    continue;
                }
                sum++;
            } else {
                flag = 0;
            }
        }
        return nums.length - sum;
    }

    private static int del(int[] nums, int i) {
        for (; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        return nums.length - 1;
    }
}
