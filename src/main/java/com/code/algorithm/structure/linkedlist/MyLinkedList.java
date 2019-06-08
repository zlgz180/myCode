package com.code.algorithm.structure.linkedlist;

import com.code.algorithm.leetcode.ListNode;

/**
 * @author tianwei
 * @since 2019-06-07 21:18
 */
public class MyLinkedList {
    private ListNode head;

    public MyLinkedList() {

    }

    public MyLinkedList(ListNode node) {
        this.head = node;
    }

    public void add(ListNode node) {
        if (node == null) {
            return;
        }
        if (head == null) {
            head = node;
            return;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public void remove(int index) {
        if (head == null || index < 0) {
            return;
        }
        int sum = 1;
        ListNode cur = head;
        while (cur != null) {
            if (sum == index) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
            sum++;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(new ListNode(1));
        myLinkedList.add(new ListNode(2));
        myLinkedList.add(new ListNode(3));

        myLinkedList.remove(1);
    }

}
