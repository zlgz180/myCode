package com.my.code.algorithm.structure.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 缓存类
 * 
 * @author tianwei
 * @since 2019-02-18 16:24
 */
public class LRUCache extends LinkedHashMap {
    private int sum;

    public LRUCache(int sum) {
        super(sum, 0.75f, true);
        this.sum = sum;
    }

    public static void main(String[] args) {
        LRUCache myLru = new LRUCache(3);
        myLru.put("1", "1");
        myLru.put("2", "1");
        myLru.put("3", "1");
        myLru.put("4", "1");
        myLru.put("5", "1");
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        if (this.size() > sum) {
            return true;
        }
        return false;
    }
}
