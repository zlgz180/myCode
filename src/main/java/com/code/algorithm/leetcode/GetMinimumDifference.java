package com.my.code.algorithm.leetcode;

/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * 
 * 示例 :
 * 
 * 输入:
 * 
 * 1 \ 3 / 2
 * 
 * 输出: 1
 * 
 * 解释: 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。 注意: 树中至少有2个节点。
 * 
 * @author tianwei
 * @since 2019/3/4 16:29
 */
public class GetMinimumDifference {
    public static void main(String[] args) {
        // new GetMinimumDifference().getMinimumDifference();
    }

    public int getMinimumDifference(TreeNode root) {
        dp(root);
        return 0;
    }

    private void dp(TreeNode root) {
        // 中序遍历，从小到大遍历，记录最小值
        dp(root.left);
        System.out.println(root.val);
        dp(root.right);
    }
}
