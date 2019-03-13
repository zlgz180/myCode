package com.code.algorithm.structure.linkedlist;

/**
 * 1）单链表的插入、删除、查找操作； 2）链表中存储的是int类型的数据；
 *
 * Author：Zheng
 * 
 * @author tianwei
 */
public class MySinglyLinkedList {

    private Node head = null;

    public static void main(String[] args) {
        MySinglyLinkedList link = new MySinglyLinkedList();
        System.out.println("hello");
        // int data[] = {1};
        // int data[] = {1,2};
        // int data[] = {1,2,3,1};
        // int data[] = {1,2,5};
        // int data[] = {1,2,2,1};
        // int data[] = {1,2,5,2,1};
        int data[] = { 1, 2, 5, 3, 1 };
        link.insertToHead(55);
        for (int i = 0; i < data.length; i++) {
            // link.insertToHead(data[i]);
            // link.insertTail(data[i]);
            link.insertBefore(link.head, data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        // System.out.println("aa"+p.data);
        // p = p.next;
        // }

        System.out.println("打印原始:");
        link.printAll();
        // if (link.palindrome()) {
        // System.out.println("回文");
        // } else {
        // System.out.println("不是回文");
        // }
    }

    public Node createNode(int value) {
        return new Node(value, null);
    }

    public Node findByValue(int value) {
        Node p = head;

        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;

        return p;
    }

    /**
     * 无头结点 表头部插入 这种操作将于输入的顺序相反，逆序
     * 
     * @param value
     */
    public void insertToHead(int value) {
        this.insertToHead(this.createNode(value));
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

    /**
     * 顺序插入 链表尾部插入
     * 
     * @param value
     */
    public void insertTail(int value) {
        Node node = this.createNode(value);
        if (head == null) {
            head = node;
            head.next = null;
            return;
        }
        // 循环找到最后一个节点，然后追加节点
        Node q = head;
        while (q.next != null) {
            q = q.next;
        }
        q.next = node;
    }

    public void insertAfter(Node p, int value) {
        if (p == null) {
            return;
        }
        p.next = this.createNode(value);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        if (p == null) {
            return;
        }
        this.insertBefore(p, this.createNode(value));
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        // 头结点就是当前这个节点
        if (this.head == p) {
            this.insertToHead(newNode);
            return;
        }

        Node t = this.head;
        // 由于是单向链表，没有保存前驱指针，只能遍历查找前驱节点
        while (t.next != p) {
            t = t.next;
        }
        t.next = newNode;
        newNode.next = t;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }
        // 找到这个节点前驱节点
        Node t = this.head;
        while (t.next == p) {
            t = t.next;
        }
        // 遍历完了还没有
        if (t == null) {
            return;
        }
        t.next = p.next;
    }

    public void deleteByValue(int value) {

    }

    // 判断是否为回文
    public void printAll() {

    }

    // 判断true or false
    public boolean TFResult(Node left, Node right) {
        return false;
    }

    public boolean palindrome() {
        return false;
    }

    // 带结点的链表翻转
    public Node inverseLinkList_head(Node p) {
        return null;
    }

    // 无头结点的链表翻转
    public Node inverseLinkList(Node p) {
        return null;
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
