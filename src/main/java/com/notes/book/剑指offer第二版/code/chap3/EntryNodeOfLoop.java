package com.notes.book.剑指offer第二版.code.chap3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoop {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 双指针法
     * 
     * @param pHead
     *            链表头结点
     * @return 环的入口结点
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode pFast = pHead;
        ListNode pSlow = pHead;
        while (pFast != null && pFast.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            // 有环
            if (pSlow.val == pFast.val) {
                pFast = pHead;
                while (pFast != pHead) {
                    pFast = pFast.next;
                    pSlow = pSlow.next;
                }
                return pFast;
            }
        }

        return null;
    }

    /**
     * 利用Set不可添加重复元素的性质
     */
    public ListNode entryNodeOfLoop_set(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = pHead;
        while (cur != null) {
            if (set.contains(cur.val)) {
                return cur;
            }
            set.add(cur.val);
            cur = cur.next;
        }
        return null;
    }

    /**
     * Map，思路同Set
     */
    public ListNode entryNodeOfLoop_map(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        Map<ListNode, Boolean> map = new HashMap<>();
        ListNode cur = pHead;
        while (cur != null) {
            if (map.containsKey(cur)) {
                return cur;
            }
            map.put(cur, true);
            cur = cur.next;
        }
        return null;
    }
}
