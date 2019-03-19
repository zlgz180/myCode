package com.code.algorithm.leetcode.linkedList;

import com.code.algorithm.leetcode.ListNode;

/**
 * @author tianwei
 * @since 2019-03-15 14:26
 */
public class Demo {
    public static void main(String[] args) {

    }

    /**
     * 例题：19 Remove Nth Node From End of List 【Medium】 <br>
     * 题意：删除链表中倒数第n个节点 test case:<br>
     * Given linked list: 1->2->3->4->5, and n = 2. <br>
     * 删除链表中导数第二个节点，变成1->2->3->5.<br>
     */
    public void fun1(ListNode head, int n) {
        ListNode f = head;
        ListNode s = head;

        // 快指针先跑N步,然后慢指针开始跑，快指针跑到头了，慢指针的下一个节点就是要删除的元素
        while (f != null) {
            if (n <= 0) {
                s = s.next;
            }
            f = f.next;
            n--;
        }
        if (s.next != null) {
            s.val = s.next.next.val;
            s.next = s.next.next;
        }
    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5. 说明：
     * <p>
     * 给定的 n 保证是有效的。
     * <p>
     * 进阶：
     * <p>
     * 你能尝试使用一趟扫描实现吗？
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode fast = listNode;
        ListNode slow = listNode;
        while (fast != null) {
            if (n <= 1) {
                slow = slow.next;
            }
            fast = fast.next;
            n--;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2->3->3->4->4->5 输出: 1->2->5 示例 2:
     * <p>
     * 输入: 1->1->1->2->3 输出: 2->3
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode f = listNode.next.next;
        ListNode s = listNode.next;
        ListNode pre = listNode;
        while (f != null) {
            if (s.val == f.val) {
                ListNode tmp = f;
                // f继续往后找
                while (tmp != null && tmp.val == s.val) {
                    tmp = tmp.next;
                }
                pre.next = tmp;
                if (tmp != null) {
                    f = tmp.next;
                    s = tmp;
                    continue;
                } else {
                    break;
                }
            }
            f = f.next;
            pre = s;
            s = s.next;
        }
        return listNode.next;
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 
     * 说明: 1 ≤ m ≤ n ≤ 链表长度。
     * 
     * 示例:
     * 
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4<br>
     * 输出: 1->4->3->2->5->NULL
     * 
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m <= 0 || n <= 0 || m >= n) {
            return null;
        }
        ListNode listNode = new ListNode(-1);

        for (int i = 0; i < n - m; i++) {

        }
        return listNode.next;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 
     * 示例：
     * 
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }
}
