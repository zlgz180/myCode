package com.code.algorithm.leetcode.linkedList;

import java.util.HashSet;

import com.code.algorithm.leetcode.ListNode;

/**
 *
 */
public class DetectCycle {
    /**
     * 如何判断一个单链表有没有环, 并找出入环点
     * 
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        HashSet set = new HashSet();
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            set.add(curr);
            curr = curr.next;
        }
        return null;
    }

    /**
     * 如何判断两个无环单链表有没有交叉点
     * 
     * @param h1
     * @param h2
     * @return
     */
    public ListNode detectCycle2(ListNode h1, ListNode h2) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = h1;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        ListNode curr2 = h2;
        while (curr2 != null) {
            if (set.contains(curr2)) {
                return curr2;
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     * 如何判断两个有环单链表有没有交叉点
     * 
     * @param h1
     * @param h2
     * @return
     */
    public ListNode detectCycle3(ListNode h1, ListNode h2) {
        return null;
    }
}
