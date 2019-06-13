package com.notes.book.剑指offer第二版;

import java.util.Arrays;

/**
 * 快排 时间复杂度nlogn 空间复杂度logn
 * <p>
 * 递归进行寻找中位数，小数左移，大数右移
 *
 * @author tianwei
 * @since 2019-06-10 12:47
 */
public class  FastSort {
    public static void main(String[] args) {
        int[] nums = { 3, 6, 1, 8, 5, 9, 5, 1 };
        fastSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void fastSort(int[] nums, int start, int end) {
        if (nums == null || nums.length <= 1 || start >= end) {
            return;
        }
        int index = getPartition(nums, start, end);
        fastSort(nums, start, index - 1);
        fastSort(nums, index + 1, end);
    }

    private static int getPartition(int[] nums, int start, int end) {
        int key = nums[start];
        int l = start;
        int r = end;
        while (r > l) {
            while (r > l && nums[r] >= key) {
                r--;
            }
            if (r > l) {
                nums[l] = nums[r];
            }
            while (r > l && nums[l] <= key) {
                l++;
            }
            if (r > l) {
                nums[r] = nums[l];
            }
        }
        nums[l] = key;
        return l;
    }

}
