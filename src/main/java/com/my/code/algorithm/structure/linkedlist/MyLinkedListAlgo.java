package com.my.code.algorithm.structure.linkedlist;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Objects;

/**
 * 1) 单链表反转 2) 链表中环的检测 3) 两个有序的链表合并 4) 删除链表倒数第n个结点 5) 求链表的中间结点
 *
 * Author: Zheng
 */
public class MyLinkedListAlgo {
    public static void main(String[] args) {

    }

    /**
     * 单链表反转<br>
     *
     *
     * @param list
     * @return
     */
    public static Node reverse(Node list) {

        return null;
    }

    public static Node myImpl(Node list) {
        if (list == null || list.next == null) {
            return list;
        }
        Node node = new Node(1, null);
        Node current = list;
        while (current != null) {
            current = list.next;
            current.next = node;
            node = current;
        }
        return list;
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

    public Node reverse3(Node node) {
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
