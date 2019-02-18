package com.my.code.algorithm.leetcode;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 */
public class RemoveElements {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode newNode = reverseList(n1);
        printAll(newNode);
    }

    public static void printAll(ListNode list) {
        ListNode p = list;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 删除链表中等于给定值 val 的所有节点。
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }

    /**
     * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            // 临时变量取出来
            ListNode next = head.next;
            // 指针反转
            head.next = pre;
            // 赋值
            pre = head;
            // 原始链表指针向后移
            head = next;
        }
        return pre;
    }

    /**
     * 递归反转链表
     *
     * @param node
     * @return
     */
    public static ListNode reverseLinkedList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            ListNode headNode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + ",next:" + (next == null ? next : next.val);
        }
    }
}
