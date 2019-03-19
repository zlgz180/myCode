package com.code.jdk.collection;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author tianwei
 * @since 2019-02-26 17:15
 */
public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        boolean empty = queue.isEmpty();
        queue.offer(null);
        queue.peek();
        queue.poll();
    }

}
