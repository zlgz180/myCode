package com.my.code.algorithm.leetcode;

/**
 * @author tianwei
 * @since 2019-02-19 14:48
 */
public class MiddleNode {
    public static void main(String[] args) {
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
