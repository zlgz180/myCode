package com.my.code.jdk.thead;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author tianwei
 * @since 2019-03-12 14:28
 */
public class sss {
    public static void main(String[] args) {
        ConcurrentSkipListMap skipListMap = new ConcurrentSkipListMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        ConcurrentSkipListSet skipListSet = new ConcurrentSkipListSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();


    }
}
