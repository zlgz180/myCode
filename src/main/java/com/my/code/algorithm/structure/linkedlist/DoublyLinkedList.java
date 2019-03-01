package com.my.code.algorithm.structure.linkedlist;

public class DoublyLinkedList {
    private Node first; // 头节点
    private Node last; // 尾节点
    private int size;

    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(long value) { // 插入头节点
        Node newLink = new Node(value);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink; // newLink <-- oldFirst.previous
            newLink.next = first; // newLink.next --> first
        }
        first = newLink; // first --> newLink
        size++;
    }

    public void insertLast(long value) {// 插入尾节点
        Node newLink = new Node(value);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink; // newLink <-- oldLast.next
            newLink.previous = last; // newLink.previous --> last
        }
        last = newLink;
        size++;
    }

    public Node deleteFirst() {// 删除头结点
        if (first == null) {
            System.out.println("链表为空！");
            return null;
        }
        Node temp = first;
        if (first.next == null) { // 只有一个节点
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        size--;
        return temp;
    }

    public Node deleteLast() {// 删除尾节点
        if (last == null) {
            System.out.println("链表为空");
            return null;
        }
        Node temp = last;
        if (last.previous == null) { // 只有一个节点
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        size--;
        return temp;
    }

    public boolean insertAfter(long key, long value) { // 在key后面插入值为value的新节点
        Node current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null) {
                System.out.println("不存在值为" + value + "的节点！");
                return false;
            }
        }
        if (current == last) {
            insertLast(value);
        } else {
            Node newLink = new Node(value);
            newLink.next = current.next;
            current.next.previous = newLink;
            newLink.previous = current;
            current.next = newLink;
            size++;
        }
        return true;
    }

    public Node deleteNode(long key) {// 删除指定位置的节点
        Node current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null) {
                System.out.println("不存在该节点！");
                return null;
            }
        }
        if (current == first) {
            deleteFirst();
        } else if (current == last) {
            deleteLast();
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }
        return current;
    }

    public void displayForward() { // 从头到尾遍历链表
        System.out.println("List(first --> last): ");
        Node current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }

    public void displayBackward() { // 从尾到头遍历链表
        System.out.println("List(last --> first): ");
        Node current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println(" ");
    }
}

class Node {
    public long data;
    public Node next;
    public Node previous;

    public Node(long value) {
        data = value;
        next = null;
        previous = null;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}
