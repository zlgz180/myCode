package com.code.algorithm.leetcode;

import java.util.*;

/**
 * @author tianwei
 * @since 2019-06-05 14:16
 */
public class LargestNumber {
    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     * 
     * 示例 1:
     * 
     * 输入: [10,2] 输出: 210 示例 2:
     * 
     * 输入: [3,30,34,5,9] 输出: 9534330 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * 
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        for (int num : nums) {
            tmp.add(num);
        }
        Collections.sort(tmp, (o1, o2) -> {
            if (o1 == 0) {
                return 1;
            }
            if (o2 == 0) {
                return -1;
            }
            if (Objects.equals(o1, o2)) {
                return 0;
            }
            // 如果长度一样，取大小
            String t1 = o1.toString();
            String t2 = o2.toString();
            // 如果长度不一样，取首尾数字
            if (t1.length() != t2.length()) {
                char c1 = t1.toCharArray()[0];
                char c2 = t2.toCharArray()[0];
                return c2 - c1;
            }
            return o2 - o1;
        });
        StringBuilder sb = new StringBuilder();
        for (Integer num : tmp) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static String largestNumber2(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>(nums.length, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        for (int item : nums) {
            pq.add(String.valueOf(item));
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            String tmp = pq.poll();
            sb.append(tmp);
        }
        String ret = sb.toString();
        while (ret.startsWith("0") && ret.length() > 1) {
            ret = ret.substring(1);
        }
        return ret;
    }

    public static void main(String[] args) {
        // int[] nums = { 123, 0, 54 };
         int[] nums = { 3, 30, 34, 5, 9 };
//        int[] nums = { 26, 33, 19, 29, 61, 66, 52, 37, 7, 76, 89, 93, 72, 2, 82, 11, 9, 41, 47, 76, 80, 28, 86, 30, 99,
//                25, 99, 85, 96, 98, 88, 33, 4, 94, 25, 80, 19, 55, 82, 71, 29, 61, 15, 2, 57, 98, 15, 91, 27, 95, 47,
//                38, 66, 2, 78, 26, 77, 33, 23, 90, 73, 27, 20, 5, 38, 23, 35, 29, 13, 46, 6, 71, 58, 37, 89, 28, 8, 1,
//                8, 73, 81, 83, 77, 22, 63, 36, 62, 89, 94, 43, 25, 86, 53, 21, 94, 9, 40, 19, 24, 21 };
        System.out.println(largestNumber2(nums));
    }
}
