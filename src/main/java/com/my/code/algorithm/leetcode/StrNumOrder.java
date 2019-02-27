package com.my.code.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 打印字符串中字符出现的次数，并按次数倒序
 *
 * @author tianwei
 * @since 2018-06-26 18:21
 */
public class StrNumOrder {
    private static final String temp = "AAADDDDBBBBCCNNNDDD";

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length(); i++) {
            char key = temp.charAt(i);
            Integer val = map.get(key);
            if (val == null) {
                map.put(key, 0);
            } else {
                map.put(key, val + 1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
            @Override public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(JSON.toJSONString(entries));
    }
}
