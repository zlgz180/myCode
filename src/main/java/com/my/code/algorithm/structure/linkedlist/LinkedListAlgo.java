package com.my.code.algorithm.structure.linkedlist;

/**
 * 1) 单链表反转 2) 链表中环的检测 3) 两个有序的链表合并 4) 删除链表倒数第n个结点 5) 求链表的中间结点
 *
 * Author: Zheng
 */
public class LinkedListAlgo {
    /**
     * 单链表反转
     *
     * @param list
     * @return
     */
    public static Node reverse(Node list) {
        Node headNode = null;

        Node previousNode = null;
        Node currentNode = list;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            previousNode = currentNode;
            currentNode = nextNode;
            currentNode.next = previousNode;
        }
        return headNode;
    }

    /**
     * 检测环
     * 
     * @param list
     * @return
     */
    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }

        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * 有序链表合并
     * 
     * @param la
     * @param lb
     * @return
     */
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }

        Node p = la;
        Node q = lb;
        Node head;
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;

        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    /**
     * 
     * @param list
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) {
            return list;
        }

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }
        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    /**
     * 递归反转链表
     *
     * @param node
     * @return
     */
    public Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node headNode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}
