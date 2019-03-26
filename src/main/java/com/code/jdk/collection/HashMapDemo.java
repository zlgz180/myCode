package com.code.jdk.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tianwei
 * @since 2019-02-26 17:15
 */
public class HashMapDemo {
    public static void main(String[] args) {
        // hashcode&(tab.length-1) 2的幂次方 hashCode%(tab.length)
        // int initialCapacity, 桶的个数
        // float loadFactor 加载因子,如果桶的加载因子数量够了就扩容桶
        HashMap map = new HashMap(3, (float) 0.75);
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        map.putIfAbsent("1", "3");// 如果key存在，val不一样，不替换

        ConcurrentHashMap hashMap = new ConcurrentHashMap(3, (float) 0.75);
        // 如果桶长度为空初始化
        // 如果桶里没数据，new 一个
        // 如果这个节点是移动状态，就帮助他移动，如果有人干活了就yeld

        // jdk7和jdk8不一样，jdk7加入到表头，jdk8是加入到表位
        // 如果桶里有链表，就把链表头加锁Sync(重入锁)，cas进行链表尾节点追加（key和val都一样需要覆盖）,链表长度到达到8就变成红黑树
        // 如果数组长度没超过64并且链表长度大于等于8，进行扩容
        // 如果数据长度超过64,并且链表长度大于等于8，进行树化
        hashMap.put("1", "2");
        // 先找桶，再遍历链表
        hashMap.get("1");

        // CounterCell（伪共享，填充满一个缓存行，避免其他线程使用，减少多级缓存反复读取） 多个size()
        hashMap.size();
        // 和put类似，把链表节点置为null
        hashMap.remove("1");


        TreeMap treeMap = new TreeMap();
        treeMap.firstEntry();// 找树最左侧的数据
        treeMap.ceilingEntry("");// 查找这个key后边最大的数


        //
        LinkedHashMap linkedHashMap = new LinkedHashMap(10, (float) 0.75, false);
        for (int i = 0; i < 10; i++) {
            linkedHashMap.put(i, i);
        }
        for (Object o : linkedHashMap.keySet()) {
            System.out.println(o);
        }
    }

}
