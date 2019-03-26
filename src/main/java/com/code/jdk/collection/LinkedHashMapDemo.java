package com.code.jdk.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tianwei
 * @since 2019-02-26 17:15
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) { // 实现自定义删除策略，否则行为就和普遍 Map 没有区别
                return size() > 3;
            }
        };
        map.put("Project1", "Valhalla");
        map.put("Project2", "Panama");
        map.put("Project3", "Loom");
        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        // 模拟访问
        map.get("Project2");
        map.get("Project2");
        map.get("Project3");
        System.out.println("Iterate over should be not affected:");
        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        // 触发删除
        map.put("Project4", "Mission Control");
        System.out.println("Oldest entry should be removed:");
        map.forEach((k, v) -> {// 遍历顺序不变
            System.out.println(k + ":" + v);
        });
    }

}
