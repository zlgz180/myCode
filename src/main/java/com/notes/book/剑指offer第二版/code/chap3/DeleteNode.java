package com.notes.book.剑指offer第二版.code.chap3;

import com.code.algorithm.leetcode.ListNode;

/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间内删除该结点。 假设要删除的结点确实在链表中
 */
public class DeleteNode {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(0);
        ListNode listNode = deleteNode_3(node, 1);
        ListNode.print(listNode);
    }

    /**
     * 常规方法，从first开始找到要删除结点的前一个结点，时间复杂度为O(n)
     */
    public static ListNode deleteNode_3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 找到头一个不重复的节点
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 中间节点
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 常规方法，从first开始找到要删除结点的前一个结点，时间复杂度为O(n)
     */
    public void deleteNode_2(ListNode first, ListNode toBeDel) {
        if (first == null || toBeDel == null) {
            return;
        }
        // 要删除的就是链表头，它没有前一个结点
        if (first == toBeDel) {
            first = first.next;
        } else {
            ListNode cur = first;
            while (cur.next != toBeDel) {
                cur = cur.next;
            }
            // cur为toBeDel的前一个结点
            cur.next = cur.next.next;
        }
    }

    /**
     * 将toBeDel的下一个结点j的值复制给toBeDel。然后将toBeDel指向j的下一个结点
     */
    public void deleteNode(ListNode first, ListNode toBeDel) {
        if (first == null || toBeDel == null) {
            return;
        }
        // 头和尾是一个节点
        if (first == toBeDel) {
            first = first.next;
            return;
        }
        // 尾节点
        if (toBeDel.next == null) {
            ListNode cur = first;
            while (cur != null && cur.next != toBeDel) {
                cur = cur.next;
            }
            cur.next = null;
            return;
        }
        // 既不是头，也不是尾节点
        ListNode next = toBeDel.next;
        if (next != null) {
            toBeDel.val = next.val;
            toBeDel.next = next.next;
        }
    }
}
