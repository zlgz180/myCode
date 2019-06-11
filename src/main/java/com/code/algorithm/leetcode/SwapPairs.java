package com.code.algorithm.leetcode;

/**
 * @author tianwei
 * @since 2019-06-06 15:12
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        // swapPairs(listNode);
        int[] nums = { 7, 1, 5, 3, 6, 4 };
        System.out.println(getMaxPrice(nums));
    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例: 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * 
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode next = cur.next;

        return null;
    }

    public static int getMaxPrice(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result = Math.max(result, nums[j] - nums[i]);
            }
        }
        return result;
    }
}
