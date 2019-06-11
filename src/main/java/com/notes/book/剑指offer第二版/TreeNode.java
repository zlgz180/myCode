package com.notes.book.剑指offer第二版;

/**
 * Created by ryder on 2017/6/12.
 * 树节点
 */
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}