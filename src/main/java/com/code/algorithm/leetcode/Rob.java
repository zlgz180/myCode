package com.code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1: 输入: [1,2,3,1] 输出: 4 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2: 输入: [2,7,9,3,1] 输出: 12 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5
 * 号房屋 (金额 = 1)。 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author tianwei
 * @since 2019-02-19 13:46
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 1, 2 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            // 重点这
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public int firstBadVersion(int n) {
        int h = n;
        int l = 0;
        int mid = 0;
        while (h >= l) {
            mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                while (true) {
                    if (!isBadVersion(--mid)) {
                        return mid + 1;
                    }
                }
            }
            l = mid + 1;
        }
        return mid;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fun(list, root);
        return list;
    }

    public void fun(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        fun(list, root.left);
        list.add(root.val);
        fun(list, root.right);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                // curr=
            }
            stack.add(curr);
            // curr.left
        }
        return null;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }

}
