package com.code.algorithm.leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void print(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out
                    .println("ListNode{" + "val=" + cur.val + (cur.next != null ? ", next=" + cur.next.val : "") + '}');
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + (next != null ? ", next=" + next.val : "") + '}';
    }
}
