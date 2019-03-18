package com.code.algorithm.structure.tree;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 二叉搜索树,父大于子女，未必平衡，可退化成链表，二叉平衡树可优化平衡
 *
 * @author tianwei
 * @since 2019/2/27 11:23
 */
public class BinarySearchTree {
    private Node tree;

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        // binarySearchTree.printByRow(root);
        // binarySearchTree.preOrder2(root);

        //        binarySearchTree.inOrder2(root);
        System.out.println(binarySearchTree.deptth(root));
    }

    /**
     * 按层遍历
     *
     * @param root
     * @return
     */
    public void printByRow(Node root) {
        // LinkedList<Node> list = new LinkedList<>();
        ArrayDeque<Node> list = new ArrayDeque<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node curr = list.poll();
            System.out.println(curr.data);
            if (curr.left != null) {
                list.add(curr.left);
            }
            if (curr.right != null) {
                list.add(curr.right);
            }
        }
    }

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 计算深度
     *
     * @param node
     * @return
     */
    public int deptth(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return Math.max(deptth(node.left), deptth(node.right)) + 1;
    }

    public Node find2(int data) {
        Node cur = this.tree;
        while (cur != null) {
            if (cur.data == data) {
                return cur;
            }
            if (cur.data > data) {
                // 找左
                cur = cur.left;
            }
            if (cur.data < data) {
                // 找右
                cur = cur.right;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 插入的数据先个父节点比较，大的往右，小的往左
     *
     * @param data
     */
    public void insert2(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node cur = this.tree;
        while (cur != null) {
            if (cur.data < data) {
                if (cur.left == null) {
                    cur.left = new Node(data);
                    return;
                }
                cur = cur.left;
            }
            if (cur.data > data) {
                if (cur.right == null) {
                    cur.right = new Node(data);
                    return;
                }
                cur = cur.right;
            }
            if (cur.data == data) {
                return;
            }
        }
    }

    public void delete(int data) {
        Node p = tree; // p指向要删除的节点，初始化指向根节点
        Node pp = null; // pp记录的是p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) {
            return; // 没有找到
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { // 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p; // minPP表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; // 将minP的数据替换到p中
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            tree = child; // 删除的是根节点
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public Node findMin() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    /**
     * 查找树最小值（左叉的左叉）
     *
     * @return
     */
    public Node findMin2() {
        if (tree == null) {
            return null;
        }
        Node cur = this.tree;
        while (cur != null) {
            if (cur.left != null) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return cur;
    }

    public Node findMax() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    public Node findMax2() {
        if (tree == null) {
            return null;
        }
        Node p = this.tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 前向遍历-->根左右
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        afterOrder(node.left);
        afterOrder(node.right);
    }

    /**
     * 前向遍历-->根左右/非递归
     */
    private void preOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.println(curr.data);
            if (curr.right != null) {
                stack.add(curr.right);
            }
            if (curr.left != null) {
                stack.add(curr.left);
            }
        }
    }

    /**
     * 中序遍历-->左根右
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    /**
     * 中序遍历-->左根右/非递归
     *
     * @param node
     */
    private void inOrder2(Node node) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left;
                continue;
            }
            node = stack.pop();
            System.out.println(node.data);
            node = node.right;
        }
    }

    /**
     * 后序遍历-->左右根
     *
     * @param node
     */
    private void afterOrder(Node node) {
        if (node == null) {
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.data);
    }

    /**
     * 后序遍历
     */
    private void afterOrder2(Node root) {
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.add(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.add(root);
            if (root.left != null) {
                stack1.add(root.left);
            }
            if (root.right != null) {
                stack1.add(root.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().data);
        }
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
