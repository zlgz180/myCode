package com.my.code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author tianwei
 * @since 2019-02-20 18:19
 */
public class ThreeSum {
    public static void main(String[] args) {

    }

    /**
     * 求3数之和等于0的集合
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; i < length; j++) {
                for (int k = j + 1; i < length; k++) {
                    if (i + j + k == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(j);
                        tmp.add(k);
                        list.add(tmp);
                    }
                }
            }
        }
        return list;
    }

    public List<List<Integer>> ss(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new LinkedList<>();
        for (int i = nums.length - 1; i >= 2;) {
            for (int j = 0, k = i - 1; j < k;) {
                int tmp = nums[j] + nums[k];
                if (tmp < -nums[i]) {
                    j++;
                } else if (tmp > -nums[i]) {
                    k--;
                } else {
                    List<Integer> rstItem = new ArrayList<>();
                    rstItem.add(nums[i]);
                    rstItem.add(nums[j]);
                    rstItem.add(nums[k]);
                    rst.add(rstItem);
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                    do {
                        k--;
                    } while (j < k && nums[k] == nums[k + 1]);
                }
            }
            do {
                i--;
            } while (i >= 2 && nums[i] == nums[i + 1]);
        }
        return rst;
    }
}
