package com.code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 *
 * @author tianwei
 * @since 2019-02-20 18:19
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(JSON.toJSONString(myImpl(nums)));
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j];
                if (tmp == -nums[k]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    break;
                }
                if (tmp > -nums[k]) {
                    while (j < k) {
                        k = k - 1;
                    }
                }
                if (tmp < nums[k]) {
                    while (j < k) {
                        j = j + 1;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 求3数之和等于0的集合
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length - 1;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        list.add(tmp);
                    }
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum4(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // 跳过可能重复的答案
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int tmp = nums[l] + nums[r];
                    if (tmp == -nums[i]) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (tmp < -nums[i]) {
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++; // 跳过重复值
                        }
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        return ls;
    }

    public static List<List<Integer>> myImpl(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 去重 得需要额外空间
        for (int i = 0; i < nums.length - 2; i++) {
            // 数组有重复，需要判断跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                while (l < r && nums[l] == nums[l + 1]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r - 1]) {
                    r--;
                }
                int tmp = nums[l] + nums[r];
                if (tmp == -nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    i++;
                    r--;
                    // l有重复
                } else if (tmp >= -nums[i]) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
