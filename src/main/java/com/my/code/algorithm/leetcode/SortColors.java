package com.my.code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tianwei
 * @since 2019-02-21 11:12
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 2, 1, 0 };
        // int[] nums = { 1, 0 };
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int zero_index = -1;
        int n = nums.length;
        int two_index = n;
        for (int i = 0; i < n;) {
            if (i >= two_index) {
                return;
            }
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, nums[++zero_index], nums[i]);
                i++;
            } else if (nums[i] == 2) {
                swap(nums, nums[i], nums[--two_index]);
            }
        }
    }

    private static void swap(int[] nums, int zero, int i) {
        int temp = nums[zero];
        nums[zero] = nums[i];
        nums[i] = temp;
    }

    public static List<Integer> sortColors2(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            switch (num) {
                case 1:
                    a.add(num);
                    break;
                case 2:
                    b.add(num);
                    break;
                case 3:
                    c.add(num);
                    break;
            }
        }
        a.addAll(b);
        a.addAll(c);
        return a;
    }
}
