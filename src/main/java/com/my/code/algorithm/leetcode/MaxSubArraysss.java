package com.my.code.algorithm.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 * 
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 */
public class MaxSubArraysss {
    public static void main(String[] args) {
        String[] nums = new String[] { "123", "12345", "1234" };
        System.out.println(longestCommonPrefix(nums));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) {
            return "";
        }
        String str = strs[0];
        StringBuilder temp = new StringBuilder();
        int j = 0;
        for (int i = 1; i < strs.length; i++) {
            String tmp = strs[i];
            for (; j < str.length(); j++) {
                if (str.charAt(j) == tmp.charAt(j)) {
                    // 如果有相同就和后边的的字符串比较
                    temp.append(str.charAt(j));

                } else {
                    return temp.substring(0, temp.length() - 1);
                }
            }
        }
        return temp.toString();
    }
}
