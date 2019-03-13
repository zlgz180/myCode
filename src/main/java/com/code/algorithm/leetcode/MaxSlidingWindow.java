package com.my.code.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口最大值。
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7] 解释:
 * 
 * 滑动窗口的位置 最大值 --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5 3 6 7 3
 * 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3 -1 -3 5
 * [3 6 7] 7 注意：
 * 
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 * 
 * @author tianwei
 * @since 2019-03-13 10:17
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println(maxSlidingWindow(nums, k));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k == 0 || k > nums.length) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 把前K个数先加入堆
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i <= nums.length; i++) {
            result[i - k] = queue.peek();
            // 堆顶元素
            System.out.println(queue.peek());
            // 移除滑动窗左边的元素
            queue.remove(nums[i - k]);
            if (i != nums.length) {
                queue.add(nums[i]);
            }
        }
        return result;
    }
}
