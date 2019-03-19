package com.code.jdk.collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author tianwei
 * @since 2019-02-22 16:51
 */
public class SortListDemo {

    public static void main(String[] args) {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });



        ConcurrentSkipListMap skipListMap = new ConcurrentSkipListMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        PriorityQueue<Object> priorityQueue = new PriorityQueue<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }
}
