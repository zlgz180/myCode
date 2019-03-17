package com.code.algorithm.structure.linkedlist;

import java.util.HashSet;

/**
 * @author tianwei
 * @since 2019-03-13 23:54
 */
public class IsCycle {

    public static void main(String[] args) {

    }

    public Boolean isCycle(Node node) {
        HashSet<Object> set = new HashSet<>();
        Node curr = node;
        while (curr != null) {
            boolean contains = set.contains(curr);
            if (!contains) {
                set.add(curr);
                curr = node.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean isCycle2(Node node) {
        Node f = node;
        Node s = node;
        while (s != null && f != null) {
            s = s.next;
            f = f.next.next;
            if (s.data == f.data) {
                return true;
            }
        }
        return false;
    }
}
