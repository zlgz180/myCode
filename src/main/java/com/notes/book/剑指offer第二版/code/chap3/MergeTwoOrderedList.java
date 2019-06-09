package com.notes.book.剑指offer第二版.code.chap3;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表. 当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoOrderedList {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 非递归实现
     * 
     * @param list1
     *            有序链表1
     * @param list2
     *            有序链表2
     * @return 合并后的有序链表
     */
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head;
        if (p1.val >= p2.val) {
            head = p1;
            p1 = p1.next;
        } else {
            head = p2;
            p2 = p2.next;
        }
        ListNode cur = head;
        //
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                cur.next = p2;
                break;
            }
            if (p2 == null) {
                cur.next = p1;
                break;
            }
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode mergeRecur(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode mergedHead = null;
        if (list1.val < list2.val) {
            mergedHead = list1;
            mergedHead.next = mergeRecur(list1.next, list2);
        } else {
            mergedHead = list2;
            mergedHead.next = mergeRecur(list1, list2.next);
        }
        return mergedHead;
    }
}
