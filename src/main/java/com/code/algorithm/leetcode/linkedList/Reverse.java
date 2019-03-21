package com.code.algorithm.leetcode.linkedList;

import java.util.Stack;

import com.code.algorithm.leetcode.ListNode;

public class Reverse {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = listNode2;
        getFristInLoop(listNode);
    }

    /**
     * 判断是否存在环
     *
     * @param curr
     */
    public static boolean isLoop(ListNode curr) {
        ListNode fast = curr;
        ListNode slow = curr;
        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否存在环
     *
     * @param curr
     */
    public static ListNode getFristInLoop(ListNode curr) {
        ListNode fast = curr;
        ListNode slow = curr;
        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                break;
            }
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 反向打印链表
     *
     * @param curr
     */
    public static void reversePrint(ListNode curr) {
        Stack<ListNode> stack = new Stack<>();
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            System.out.println(pop);
        }
    }

    /**
     * 反转链表
     *
     * @param curr
     * @return
     */
    public static ListNode reverse(ListNode curr) {
        if (curr == null || curr.next == null) {
            return null;
        }
        ListNode pre = null;
        while (curr != null) {
            // 先把next拿出来等待交换
            ListNode next = curr.next;
            // 断开链接
            curr.next = pre;
            // 双指针后移
            pre = curr;
            curr = next;
        }
        return pre;
    }


}
