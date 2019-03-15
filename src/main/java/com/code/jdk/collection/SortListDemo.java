package com.code.jdk.collection;

import java.util.*;
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

        map.firstKey();

        ConcurrentSkipListMap skipListMap = new ConcurrentSkipListMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        Collections.sort(null);
        int[] a = {};
        Arrays.parallelSort(a);


        PriorityQueue<Object> priorityQueue = new PriorityQueue<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }
}
