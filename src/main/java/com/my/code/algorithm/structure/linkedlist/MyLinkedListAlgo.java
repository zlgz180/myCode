package com.my.code.algorithm.structure.linkedlist;

import com.google.common.base.Objects;

/**
 * 1) 单链表反转 </br>
 * 2) 链表中环的检测 </br>
 * 3) 两个有序的链表合并 </br>
 * 4) 删除链表倒数第n个结点 </br>
 * 5) 求链表的中间结点 </br>
 *
 * @author tianwei
 */
public class MyLinkedListAlgo {
    public static void main(String[] args) {
        // 创建链表的节点，创建了三个对象，那就是三个节点,将这些节点，串连起来形成链表
        Node node2 = new Node(3, null);
        Node node1 = new Node(2, node2);
        Node node0 = new Node(1, node1);
        // 打印反转后的节点
        printAll(reverse3(node0));
    }

    /**
     * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
     *
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {
        Node pre = null;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 检测环
    public static boolean checkCircle(Node list) {

        return false;
    }

    // 有序链表合并
    public static Node mergeSortedLists(Node la, Node lb) {
        return null;
    }

    /**
     * 删除倒数第K个结点<br>
     * 1.用数组<br>
     * 2.
     *
     * @param list
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node list, int k) {
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        return null;
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

    public static void printNode(Node node) {
        if (node != null) {
            System.out
                    .println("data :" + node.getData() + " next :" + (node.next == null ? null : node.next.getData()));
        }
    }

    public static Node reverse3(Node node) {
        if (node.next == null) {
            return node;
        }
        Node next = node.next;
        node.next = null;
        Node re = reverse3(next);
        next.next = node;
        return re;
    }

    public static class Node {
        private Node head;
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node node = (Node) o;
            return getData() == node.getData() && Objects.equal(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(getData(), next);
        }

        /**
         * 插入头结点
         *
         * @param newNode
         */
        public void insertToHead(Node newNode) {
            if (this.head == null) {
                head = newNode;
            } else {
                // 插入节点指向当前的头
                newNode.next = head;
                // 插入节点的值覆盖head的值
                head = newNode;
            }
        }
    }
}
