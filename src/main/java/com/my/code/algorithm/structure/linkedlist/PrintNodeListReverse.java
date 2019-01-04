package com.my.code.algorithm.structure.linkedlist;

import java.util.Stack;

/**
 * @author tianwei
 * @since 2018-07-04 9:53
 */
public class PrintNodeListReverse {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        // reverse(n1);
        recursive(n1);
    }

    /**
     * 链表转栈，栈先进后出
     * 
     * @param node
     */
    public static void reverse(Node node) {
        Stack<Node> stack = new Stack<Node>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().data);
        }
    }

    /**
     * 递归展示
     * 
     * @param node
     */
    public static void recursive(Node node) {
        if (node.next != null) {
            recursive(node.next);
        }
        System.out.println(node.data);
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
