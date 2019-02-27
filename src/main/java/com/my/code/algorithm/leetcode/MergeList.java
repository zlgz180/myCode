package com.my.code.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author tianwei
 * @since 2019-02-26 15:20
 */
public class MergeList {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        int[] b = { 3, 4, 5, 6 };
        System.out.println(Arrays.toString(mergeArray(a, a.length, b, b.length)));

        ListNode m = new ListNode(1);
        m.next = new ListNode(2);
        ListNode n = new ListNode(3);
        ListNode listNode = mergeLinkedList2(m, n);
        ListNode.print(listNode);


        ListNode q = new ListNode(1);
        q.next = new ListNode(2);
        q.next.next = new ListNode(3);
        q.next.next.next = new ListNode(4);
        System.out.println("中节点" + middle(q));


        ListNode y = new ListNode(1);
        y.next = new ListNode(2);
        y.next.next = new ListNode(3);
        y.next.next.next = new ListNode(1);
        System.out.println(checkCircle(y));


        ListNode z = new ListNode(1);
        z.next = new ListNode(2);
        z.next.next = new ListNode(3);
        System.out.println("反转" + reverse(z));
    }

    /**
     * 合并两个有序数组
     * 
     * @param a
     * @param al
     * @param b
     * @param bl
     * @return
     */
    public static int[] mergeArray(int[] a, int al, int[] b, int bl) {
        int k = al + bl;
        int[] result = new int[k];

        while (al > 0 && bl > 0) {
            if (a[al - 1] >= b[bl - 1]) {
                result[k - 1] = a[al - 1];
                k--;
                al--;
            } else {
                result[k - 1] = b[bl - 1];
                k--;
                bl--;
            }
        }
        while (al != bl) {
            if (al > bl) {
                result[k - 1] = a[al - 1];
                k--;
                al--;
            } else {
                result[k - 1] = b[bl - 1];
                k--;
                bl--;
            }
        }
        return result;
    }

    /**
     * 合并两个有序链表
     * 
     * @param a
     * @param b
     * @return
     */
    public static ListNode mergeLinkedList(ListNode a, ListNode b) {
        ListNode aCurrent = a;
        ListNode bCurrent = b;

        ListNode result = new ListNode(-1);

        ListNode next = result;
        while (aCurrent != null && bCurrent != null) {
            if (aCurrent.val <= bCurrent.val) {
                next.next = aCurrent;
                aCurrent = aCurrent.next;
            } else {
                next.next = bCurrent;
                bCurrent = bCurrent.next;
            }
            next = next.next;
        }
        while (aCurrent != null) {
            next.next = aCurrent;
            aCurrent = aCurrent.next;
            next = next.next;
        }
        while (bCurrent != null) {
            next.next = bCurrent;
            bCurrent = bCurrent.next;
            next = next.next;
        }
        return result.next;
    }

    /**
     * 递归合并有序链表
     * 
     * @param a
     * @param b
     * @return
     */
    public static ListNode mergeLinkedList2(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode head = null;
        if (a.val <= b.val) {
            head = a;
            head.next = mergeLinkedList2(a.next, b);
        } else {
            head = b;
            head.next = mergeLinkedList2(a, b.next);
        }
        return head;
    }

    public static ListNode middle(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode fast = node;
        ListNode low = node;
        while (fast.next.next != null && low.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }

    /**
     * 检测是否有环
     * 
     * @param list
     * @return
     */
    public static boolean checkCircle(ListNode list) {
        if (list == null) {
            return false;
        }
        ListNode fast = list.next;
        ListNode slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.val == slow.val) {
                return true;
            }
        }
        return false;
    }

    /**
     * 单向链表反转
     *
     * @param list
     */
    public static ListNode reverse(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode pre = null;
        ListNode curr = list;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
