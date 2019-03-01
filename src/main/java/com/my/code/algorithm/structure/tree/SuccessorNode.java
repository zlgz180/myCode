package com.my.code.algorithm.structure.tree;

/**
 * 寻找一个节点的后继节点和前驱节点
 */
public class SuccessorNode {
    /**
     * 传入一个node，返回该node的后继节点
     *
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getMostLeft(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && node != parent.left) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /**
     * 返回node为根节点的最左边节点
     *
     * @param node
     * @return
     */
    private static Node getMostLeft(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 返回node节点的前驱节点
     *
     * @param node
     * @return
     */
    public static Node getPioneerNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.left != null) {
            return getMostRight(node.left);
        } else {
            Node parent = node.parent;
            while (parent != null && node != parent.right) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /**
     * 返回以node为根节点的最右边节点
     *
     * @param node
     * @return
     */
    private static Node getMostRight(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }

    private static class Node {
        private Integer value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

}
