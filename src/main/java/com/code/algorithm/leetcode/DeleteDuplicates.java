package com.code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2 输出: 1->2 示例 2:
 * 
 * 输入: 1->1->2->3->3 输出: 1->2->3
 * 
 * @author tianwei
 * @since 2019-02-19 13:46
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        head.next = head.next.next.next;

        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(4);
        // System.out.println(deleteDuplicates(head));
        // System.out.println(deleteDuplicates2(head));
        System.out.println();


    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && (curr.next != null)) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return curr;
    }

    /**
     * 连带着重复元素也的跟着删除
     * 
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        // 重复元素的根元素
        List<ListNode> list = new ArrayList<>();
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode current = head;
        while (current != null && current.next != null) {
            // 前后有相等的
            if (current.val == current.next.val) {
                current.next = current.next.next;
                list.add(pre);
            } else {
                // 没有重复就往后走
                pre = current;
                current = current.next;
            }
        }
        // 删除重复元素的根元素
        for (ListNode listNode : list) {
            listNode.next = listNode.next.next;
        }
        return pre.next;
    }
}
