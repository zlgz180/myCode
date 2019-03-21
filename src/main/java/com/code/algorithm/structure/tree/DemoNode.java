package com.code.algorithm.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找一个节点的后继节点和前驱节点
 */
public class DemoNode {
    public Boolean isSortTree(Node node) {
        // 中序遍历,得到有序数组
        List<Integer> list = new ArrayList();
        fun(list, node);
        // 如果不是有序就不是二叉搜索树
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void fun(List list, Node node) {
        fun(list, node.left);
        list.add(node.value);
        fun(list, node.right);
    }


    public static class Node {
        private Integer value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

}
