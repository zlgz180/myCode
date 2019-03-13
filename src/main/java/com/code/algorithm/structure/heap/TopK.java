package com.code.algorithm.structure.heap;

import java.util.PriorityQueue;

public class TopK {

    /**
     * 求第k大的元素
     *
     * @param k
     * @param a
     */
    public void sort(int k, int[] a) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int n : a) {
            if (queue.size() < k) {
                queue.add(n);
            }
            if (queue.peek() < n) {
                queue.poll();
                queue.add(n);
            }
        }

        for (Integer integer : queue) {
            queue.poll();
        }
    }

}
