package com.my.code.algorithm.leetcode;

/**
 *
 * 
 * @author tianwei
 * @since 2018-07-04 10:38
 */
public class Problem6<T> {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7 };
    }

    /**
     * 删掉N节点
     * 
     * @param head
     * @param n
     */
    public static void deleteNode(Node head, Node n) {
        if (head == null || n == null) {
            return;
        }
        // 头节点
        if (head == n) {
            head = null;
            return;
        }
        // 尾节点
        if (n.next == null) {
            n = null;
            return;
        }
        // 中间节点
        n.next = n.next.next;
    }

    static class Node {
        Node next;
        Node pre;
        Integer data;

        public Node() {
        }

        public Node(Integer data) {
            this.data = data;
        }
    }
}
