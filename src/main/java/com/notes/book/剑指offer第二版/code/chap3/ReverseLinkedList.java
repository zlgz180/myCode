package com.notes.book.剑指offer第二版.code.chap3;

import java.util.LinkedList;

/**
 * 输入一个链表的头结点，反转链表后，并返回反转链表的头结点。
 */
public class ReverseLinkedList {
    /**
     * 用栈，空间复杂度为O(N)不推荐
     *
     * @param head 头结点
     * @return 反转之后的链表头结点
     */
    public ListNode reverseList_2(ListNode head) {
        if (head == null) {
            return null;
        }
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        head = stack.pop();
        cur = head;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;

        return head;
    }

    /**
     * 推荐，使用三个指针
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归，不太推荐。虽然很巧妙
     */
    public ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode revHead = reverseListRecur(head.next);
        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = null;
        return revHead;
    }

    /**
     * 链表相遇点
     * 
     * @param head
     * @return
     */
    public ListNode joinPoint(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 相遇点
                break;
            }
        }
        // fast回终点
        fast = head;
        while (fast.val != slow.val) {
            fast = fast.next;
            slow = slow.next;
        }
        // 入口
        return fast;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
