package com.notes.book.剑指offer第二版.code;

import com.code.algorithm.leetcode.ListNode;

/**
 * @author tianwei
 * @since 2019-06-15 12:08
 */
public class ListNodeTest {

    /**
     * 删除节点
     * 
     * @param head
     */
    public void remove(ListNode head) {
        // 删除头结点
        head = head.next;

        // 删除下一个节点
        head.next = head.next.next;

        // 删除当前节点或者尾节点
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = pre.next.next;
    }

    /**
     * 查找
     * 
     * @param head
     * @param newNode
     */
    public void add(ListNode head, ListNode newNode) {
        // 插入头结点
        newNode.next = head;

        // 插入下一个节点
        head.next = newNode;
        newNode.next = head.next.next;

        // 插入尾节点
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null) {
                cur.next = newNode;
            }
        }
    }

}
