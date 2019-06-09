package com.notes.book.剑指offer第二版.code.chap2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 */
public class TwoQueueImpStack {
    private Queue<Integer> a=new LinkedList<>();
    private Queue<Integer> b=new LinkedList<>();

    public void push(int node) {
        if (a.isEmpty() && b.isEmpty()) {
            a.offer(node);
        } else if (!a.isEmpty()){
            a.offer(node);
        } else {
            b.offer(node);
        }
    }

    public int pop() {
        if (a.isEmpty() && b.isEmpty()) {
            throw new RuntimeException("栈已空");
        }

        if (!b.isEmpty()) {
            int size = b.size();
            // 除了最后一个元素，其他都删除并复制到另外一个队列中
            for (int i = 0; i < size - 1; i++) {
                a.offer(b.poll());
            }
            return b.poll();
        } else {
            int size = a.size();
            for (int i = 0; i < size -1; i++) {
                b.offer(a.poll());
            }
            return a.poll();
        }
    }


    public static void main(String[] args) {
        TwoQueueImpStack a = new TwoQueueImpStack();
        a.push(54);
        a.push(55);
        a.push(56);
        System.out.println(a.pop());
        System.out.println(a.pop());
        a.push(53);
        System.out.println(a.pop());
        a.push(52);
        System.out.println(a.pop());
        System.out.println(a.pop());
    }
}
