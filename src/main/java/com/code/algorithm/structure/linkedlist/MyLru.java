package com.code.algorithm.structure.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tianwei
 * @since 2019-04-15 16:40
 */
public class MyLru extends LinkedHashMap {
    private int sum;

    public MyLru(int sum) {
        this.sum = sum;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > sum;
    }
}
