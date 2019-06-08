package com.notes.book.剑指offer第二版.code;

import java.util.Arrays;

/**
 * 将有序数组B归并到有序数组A中（A能容纳下B），归并后的A数组也是有序的
 */
public class MergeTwoSortedArray {
    /**
     * 把b数组往a里灌，保证有序，如果从前往后所有字符都要移动，从后往前的话，只移动一次
     *
     * @param a
     * @param b
     */
    public static void merge(Integer[] a, Integer[] b) {
        if (a == null || b == null) {
            return;
        }
        int alen = a.length - 1;
        int blen = b.length - 1;
        int aContentLen = 0;
        for (Integer i : a) {
            if (i != null) {
                aContentLen++;
            } else {
                break;
            }
        }
        aContentLen -= 1;
        // 比较两个数组的最大值
        while (alen >= 0) {
            // 如果a数组都搬空了，直接搬b
            if (aContentLen < 0 && blen >= 0) {
                a[alen] = b[blen];
                blen--;
                alen--;
                continue;
            }
            // 如果b都搬空了搬a
            if (aContentLen >= 0 && blen < 0) {
                a[alen] = a[aContentLen];
                aContentLen--;
                alen--;
                continue;
            }
            // 谁大谁放在a数组最后
            if (a[aContentLen] > b[blen]) {
                a[alen] = a[aContentLen];
                aContentLen--;
                alen--;
            } else if (a[aContentLen] <= b[blen]) {
                a[alen] = b[blen];
                blen--;
                alen--;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        Integer[] b = { 1, 3, 5, 7, 9 };
        // {2, 4, 6, 8, 10}
        for (int i = 0; i < 5; i++) {
            a[i] = 2 * i + 2;
        }

        merge(a, b);
        System.out.println(Arrays.toString(a));
    }
}
