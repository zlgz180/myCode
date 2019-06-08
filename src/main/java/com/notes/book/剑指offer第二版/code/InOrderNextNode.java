package com.notes.book.剑指offer第二版.code;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class InOrderNextNode {

    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        // parent指向父结点
        TreeLinkNode parent = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        // 如果当前节点有右节点，则下一个节点就是当前节点的右子树最小值
        if (pNode.right != null) {
            // 找当前节点右子树最左节点
            pNode = pNode.right;
            while (pNode != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 如果当前节点没有右节点，就是齐父节点的父节点
        if (pNode.right == null) {
            if (pNode.parent.right == pNode) {

            }
            return pNode.parent;
        }
        return null;
    }
}
