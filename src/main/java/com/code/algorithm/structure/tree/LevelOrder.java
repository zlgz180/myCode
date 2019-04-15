package com.code.algorithm.structure.tree;

/**
 *给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]
 * @author tianwei
 * @since 2019/4/12 15:57
 */
public class LevelOrder {
    public static class Node {
        private int data;
        private MyBinaryTree.Node left;
        private MyBinaryTree.Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
