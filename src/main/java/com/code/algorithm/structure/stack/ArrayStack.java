package com.code.algorithm.structure.stack;

/**
 * 数组实现栈
 */
public class ArrayStack {
    private long[] a;
    private int size; // 栈数组的大小
    private int top; // 栈顶

    public ArrayStack(int maxSize) {
        this.size = maxSize;
        this.a = new long[size];
        this.top = -1; // 表示空栈
    }

    public void push(long value) {// 入栈
        if (isFull()) {
            System.out.println("栈已满！");
            return;
        }
        a[++top] = value;
    }

    public long peek() {// 返回栈顶内容，但不删除
        if (isEmpty()) {
            System.out.println("栈中没有数据");
            return 0;
        }
        return a[top];
    }

    public long pop() { // 弹出栈顶内容，删除
        if (isEmpty()) {
            System.out.println("栈中没有数据！");
            return 0;
        }
        return a[top--];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
