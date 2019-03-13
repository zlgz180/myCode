package com.code.algorithm.leetcode;

import java.util.LinkedList;

/**
 * @author tianwei
 * @since 2019-02-01 17:33
 */
public class Tree {

    public static void main(String[] args) {
        // 构造链表结构测试用
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;
        System.out.print("recursivePreOrder: ");
        recursivePreOrder(a);
        System.out.print('\n' + "recursiveInOrder: ");
        recursiveInOrder(a);
        System.out.print('\n' + "recursivePostOrder: ");
        recursivePostOrder(a);
        System.out.print('\n' + "iterativePreOrder: ");
    }


    public static void visit(TreeNode p) {
        System.out.print(p.val + " ");
    }


    // **********递归的先序遍历**********
    public static void recursivePreOrder(TreeNode p) {
        if (p == null) {
            return;
        }
        visit(p);
        recursivePreOrder(p.left);
        recursivePreOrder(p.right);
    }


    // **********递归的中序遍历**********
    public static void recursiveInOrder(TreeNode p) {
        if (p == null) {
            return;
        }
        recursiveInOrder(p.left);
        visit(p);
        recursiveInOrder(p.right);
    }


    // **********递归的后序遍历**********
    public static void recursivePostOrder(TreeNode p) {
        if (p == null) {
            return;
        }
        recursivePostOrder(p.left);
        recursivePostOrder(p.right);
        visit(p);
    }

    /**
     * 前序遍历 根-->左-->右
     */
    public static void DFS(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            DFS(root.left);
            DFS(root.right);
        }
    }

    /**
     * 前序遍历 非递归实现
     * 
     * @param root
     */
    public static void DFSMorege(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode treeNode = root;
        while (true) {
            if (treeNode != null) {
                System.out.println(treeNode.val);
                list.add(treeNode);
                treeNode = treeNode.left;
            } else {
                TreeNode pop = list.pop();
                treeNode = pop.right;
            }
        }
    }


    /**
     * 中序遍历 左/根/右
     * 
     * @param root
     */
    public static void DFS2(TreeNode root) {
        if (root != null) {
            DFS(root.left);
            System.out.println(root.val);
            DFS(root.right);
        }
    }

    /**
     * 后序遍历 左/右/根
     *
     * @param root
     */
    public static void DFS3(TreeNode root) {
        if (root != null) {
            DFS(root.left);
            DFS(root.right);
            System.out.println(root.val);
        }
    }
}
