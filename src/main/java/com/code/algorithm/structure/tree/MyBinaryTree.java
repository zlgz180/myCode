package com.code.algorithm.structure.tree;

import com.code.algorithm.leetcode.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉搜索树,父大于子女，未必平衡，可退化成链表，二叉平衡树可优化平衡
 *
 * @author tianwei
 * @since 2019/2/27 11:23
 */
public class MyBinaryTree {
    private Node tree;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        //        preOrder(root);
        //        inOrder(root);
        //        postOrder(root);
        printByRow(root);
    }

    private static boolean result = true;

    /**
     * 是否是平衡二叉树
     *
     * @param node
     * @return
     */
    public static Boolean isBTree(Node node) {
        dept(node);
        return result;
    }

    private static int dept(Node node) {
        if (node == null) {
            return 0;
        }
        int left = dept(node.left);
        int right = dept(node.right);
        if (Math.abs(left - right) > 1) {
            result = false;
        }
        return right > left ? right + 1 : left + 1;
    }

    /**
     * 按行输出，队列
     *
     * @param root
     */
    private static void printByRow(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> linkedList = new LinkedList();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            Node poll = linkedList.poll();
            System.out.println(poll.data);
            if (poll.left != null) {
                linkedList.add(poll.left);
            }
            if (poll.right != null) {
                linkedList.add(poll.right);
            }
        }
    }

    private static ListNode revers(ListNode root) {
        ListNode pre = new ListNode(-1);
        ListNode cur = root;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre.next;
    }

    /**
     * 非递归前序遍历 根左右
     *
     * @param root
     */
    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            //第二层先出来左节点做为根节点
            //根
            Node cur = stack.pop();
            //本层栈是先进后出
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            System.out.println(cur.data);
        }
    }

    /**
     * 中序遍历非递归 左根右
     *
     * @param root
     */
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
                continue;
            }
            //弹出左节点
            Node node = stack.pop();
            System.out.println(node.data);
            cur = node.right;
        }
    }

    public static void postOrder(Node root) {
        //2个栈

    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
