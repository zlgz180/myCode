package com.notes.book.剑指offer第二版.code.chap3;

/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间内删除该结点。假设要删除的结点确实在链表中
 */
public class DeleteNode {

    private class Node {
        int val;
        Node next;
    }

    /**
     * 常规方法，从first开始找到要删除结点的前一个结点，时间复杂度为O(n)
     */
    public void deleteNode_2(Node first, Node toBeDel) {
        if (first == null || toBeDel == null) {
            return;
        }
        // 要删除的就是链表头，它没有前一个结点
        if (first == toBeDel) {
            first = first.next;
        } else {
            Node cur = first;
            while (cur.next != toBeDel) {
                cur = cur.next;
            }
            // cur为toBeDel的前一个结点
            cur.next = cur.next.next;
        }
    }

    /**
     * 将toBeDel的下一个结点j的值复制给toBeDel。然后将toBeDel指向j的下一个结点
     */
    public void deleteNode(Node first, Node toBeDel) {
        if (first == null || toBeDel == null) {
            return;
        }
        // 头和尾是一个节点
        if (first == toBeDel) {
            first = first.next;
            return;
        }
        // 尾节点
        if (toBeDel.next == null) {
            Node cur = first;
            while (cur != null && cur.next != toBeDel) {
                cur = cur.next;
            }
            cur.next = null;
            return;
        }
        // 既不是头，也不是尾节点
        Node next = toBeDel.next;
        if (next != null) {
            toBeDel.val = next.val;
            toBeDel.next = next.next;
        }
    }
}
