package com.my.code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 翻转一棵二叉树。
 * 
 * 示例：
 * 
 * 输入：
 * 
 * 4 / \ 2 7 / \ / \ 1 3 6 9 输出：
 * 
 * 4 / \ 7 2 / \ / \ 9 6 3 1
 * 
 * @author tianwei
 * @since 2019/2/27 14:56
 */
public class BTree {
    double last = -Double.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        // root.right = new TreeNode(3);
        System.out.println(new BTree().isValidBST(root));
    }

    /**
     * 反转一棵树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return root;
        }
        root.left = right;
        root.right = left;
        if (root.right != null) {
            invertTree(root.right);
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        return 1 + Math.max(minDepth(root.left), minDepth(root.right));
    }

    /**
     * 二叉树层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rowList = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            TreeNode right = cur.right;

        }
        return rowList;
    }

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     *
     * 节点的右子树只包含大于当前节点的数。
     *
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 
     * 说明: 叶子节点是指没有子节点的节点。
     * 
     * 示例: 给定如下二叉树，以及目标和 sum = 22，
     * 
     * 5 / \ 4 8 / / \ 11 13 4 / \ \ 7 2 1 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径
     * 5->4->11->2。
     * 
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.left.val) || hasPathSum(root.right, sum - root.right.val);
    }
}
