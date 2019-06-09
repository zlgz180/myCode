package com.notes.book.剑指offer第二版.code.chap3;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5 注意重复的结点不保留：并不是将重复结点删除到只剩一个，而是重复结点的全部会被删除。所以
 * 链表1->2->3->3->4->4->5不是1->2->3->4->5
 */
public class DeleteDuplicationNode {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode pre = new ListNode(pHead.val - 1);
        pre.next = pHead;
        ListNode cur = pHead;

        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
                continue;
            }
            // 当前节点和下一节点值一样，则都 删除
            // 重复可能有多个
            while (cur != null && cur.next != null && cur.next.val == cur.val) {
                cur = cur.next.next;
            }
            pre.next = cur;
        }
        return pHead;
    }

    public static void main(String[] args) {
        DeleteDuplicationNode demo = new DeleteDuplicationNode();
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(2);

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        System.out.println(demo.deleteDuplication(head));
    }
}
