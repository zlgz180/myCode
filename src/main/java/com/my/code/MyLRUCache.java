package com.my.code;

import java.util.HashMap;

/**
 * @author tianwei
 * @since 2018-07-02 11:36
 */
public class MyLRUCache<K, V> {
    private HashMap<K, Entry> map;
    private Integer cap;

    private Entry first;
    private Entry last;

    public MyLRUCache(Integer cap) {
        this.cap = cap;
        map = new HashMap<>();
    }

    public void put(K key, V val) {
        Entry entry = map.get(key);
        if(entry==null){

        }
    }

    class Entry<K, V> {
        Entry pre;
        Entry next;
        K key;
        V val;
    }
}
