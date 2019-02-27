package com.my.code.algorithm.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void print(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.println(
                    "ListNode{" + "val=" + cur.val + (cur.next != null ? ", next=" + cur.next.val : "") + '}');
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + (next != null ? ", next=" + next.val : "") + '}';
    }
}
