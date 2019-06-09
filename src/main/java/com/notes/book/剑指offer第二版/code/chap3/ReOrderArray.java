package com.notes.book.剑指offer第二版.code.chap3;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int l = 0;
        int r = array.length - 1;
        int[] tmp = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                tmp[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) != 1) {
                tmp[index] = array[i];
                index++;
            }
        }
    }

    public void reOrderArray2(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            // 如果左边是奇数，右边是偶数，就交换位置
            if (a[l] % 2 == 0 && a[r] % 2 == 1) {
                int tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;
                l++;
                r--;
                continue;
            }
            // 左边是偶数
            if (a[l] % 2 == 1) {
                l++;
            }
            if (a[r] % 2 == 0) {
                r--;
            }
        }
    }

    public static void main(String[] args) {
        ReOrderArray reOrder = new ReOrderArray();
        int[] a = { 3, 2, 1, 9, 8, 7, 4, 5, 6 };
        reOrder.reOrderArray2(a);
        System.out.println(Arrays.toString(a));
    }
}
