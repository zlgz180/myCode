package com.code.jdk.collection;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author tianwei
 * @since 2019-02-26 17:15
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap map = new HashMap(3);
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }

        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        boolean empty = queue.isEmpty();
        queue.offer(null);
        queue.peek();
        queue.poll();
    }

}
