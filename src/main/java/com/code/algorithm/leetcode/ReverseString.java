package com.code.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author tianwei
 * @since 2019-03-24 11:30
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = { 'a', 'b', 'c', 'd','e' };
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");

        return "";
    }
    public static void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    private static void swap(char[] s, int l, int r) {
        char tmp = s[l];
        s[l] = s[r];
        s[r] = tmp;
    }
}
