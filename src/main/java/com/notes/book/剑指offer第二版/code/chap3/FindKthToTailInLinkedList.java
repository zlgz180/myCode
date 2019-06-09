package com.notes.book.剑指offer第二版.code.chap3;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTailInLinkedList {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 一个指针得遍历两边，n-k+1步就是K的位置
     *
     * 俩指针就遍历一遍，a指针先走K步，b从头开始，然后a,b一块走，a尾了，b就是倒数K步
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 先走K步
        int sum = 0;
        while (fast != null && sum < k) {
            fast = fast.next;
            sum++;
        }
        if (k - sum > 1) {
            return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        new FindKthToTailInLinkedList().FindKthToTail(head, 21);
    }
}
