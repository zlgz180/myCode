package com.code.algorithm.structure.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * @author tianwei
 * @since 2019-04-15 16:40
 */
public class MyLru extends LinkedHashMap {
    private int sum;
    private int failNum;

    public MyLru(int sum) {
        super(sum, 0.75f, true);
        this.sum = sum;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        if (size() > sum) {
            failNum++;
            return true;
        }
        return false;
    }

    public int addAll(Map m) {
        super.putAll(m);
        return failNum;
    }

    public static void main(String[] args) {
        MyLru myLru = new MyLru(5);
        Map map = new HashMap();
        for (int i = 0; i < 20; i++) {
            map.put(i, i);
        }

        Executors.newCachedThreadPool();
        int i = myLru.addAll(map);
        System.out.println(i);
    }
}
