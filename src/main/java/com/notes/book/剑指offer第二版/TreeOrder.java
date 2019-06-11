package com.notes.book.剑指offer第二版;

import java.util.*;

/**
 * 二叉树的遍历：
 *
 * 前序（递归，非递归）
 *
 * 中序（递归，非递归）
 * 
 * 后序（递归，非递归）
 *
 * 层序
 */
public class TreeOrder {
    /**
     * 前序遍历递归版 根左右
     * 
     * @param node
     * @return
     */
    public static List<Integer> preOrder(TreeNode<Integer> node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        result.add(node.val);
        result.addAll(preOrder(node.left));
        result.addAll(preOrder(node.right));
        return result;
    }

    /**
     * 中序遍历递归版 左根右
     * 
     * @param node
     * @return
     */
    public static List<Integer> inorderRecursively(TreeNode<Integer> node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        result.addAll(preOrder(node.left));
        result.add(node.val);
        result.addAll(preOrder(node.right));
        return result;
    }

    /**
     * 后序遍历递归版
     * 
     * @param node
     * @return
     */
    public static List<Integer> postorderRecursively(TreeNode<Integer> node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        result.addAll(preOrder(node.left));
        result.addAll(preOrder(node.right));
        result.add(node.val);
        return result;
    }

    /**
     * 前序遍历非递归版 利用栈来保存根右
     * 
     * @param node
     * @return
     */
    public static List<Integer> preorderIteratively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                list.add(cur.val);
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop().right;
            }
        }
        return list;
    }

    /**
     * 中序遍历非递归版
     * 
     * @param node
     * @return
     */
    public static List<Integer> inorderIteratively(TreeNode<Integer> node) {
        List<Integer> list = new LinkedList<>();
        if (node == null) {
            return list;
        }
        // stack栈顶元素永远为cur的父节点
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                list.add(stack.peek().val);
                cur = stack.pop().right;
            }
        }
        return list;
    }

    /**
     * 后序遍历非递归版
     * 
     * @param node
     * @return
     */
    public static List<Integer> postorderIteratively(TreeNode<Integer> node) {
        List<Integer> list = new LinkedList<>();
        if (node == null) {
            return list;
        }
        // stack栈顶元素永远为cur的父节点
        // prevVisted用于区分是从左子树还是右子树返回的
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        TreeNode<Integer> prevVisted = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek().right;
                if (cur != null && cur != prevVisted) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    prevVisted = stack.pop();
                    list.add(prevVisted.val);
                    cur = null;
                }
            }
        }
        return list;
    }

    /**
     * 层序遍历
     * 
     * @param node
     * @return
     */
    public static List<Integer> levelorder(TreeNode<Integer> node) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        TreeNode<Integer> temp = null;
        if (node == null) {
            return list;
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // 1
        // \
        // 2
        // /
        // 3
        // pre->123 in->132 post->321 level->123
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.right = new TreeNode<Integer>(2);
        root.right.left = new TreeNode<Integer>(3);
        List<Integer> list_preorderRecursively = preOrder(root);
        System.out.print("preorderRecursively: " + '\t');
        System.out.println(list_preorderRecursively.toString());

        List<Integer> list_inorderRecursively = inorderRecursively(root);
        System.out.print("inorderRecursively: " + '\t');
        System.out.println(list_inorderRecursively.toString());

        List<Integer> list_postorderRecursively = postorderRecursively(root);
        System.out.print("postorderRecursively: " + '\t');
        System.out.println(list_postorderRecursively.toString());
        System.out.println();


        List<Integer> list_preorderIteratively = preorderIteratively(root);
        System.out.print("preorderIteratively: " + '\t');
        System.out.println(list_preorderIteratively.toString());

        List<Integer> list_inorderIteratively = inorderIteratively(root);
        System.out.print("inorderIteratively: " + '\t');
        System.out.println(list_inorderIteratively.toString());

        List<Integer> list_postorderIteratively = postorderIteratively(root);
        System.out.print("postorderIteratively: " + '\t');
        System.out.println(list_postorderIteratively.toString());
        System.out.println();

        List<Integer> list_levelorder = levelorder(root);
        System.out.print("levelorder: " + '\t');
        System.out.println(list_levelorder.toString());
    }
}
