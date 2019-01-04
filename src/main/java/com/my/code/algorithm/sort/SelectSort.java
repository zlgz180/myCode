package com.my.code.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 选择排序
 * 
 * @author tianwei
 * @since 2019-01-04 14:11
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = new int[] { 2, 6, 4, 3, 1, 7 };
        selectionSort(a, a.length);
        // myTest(a);
        System.out.println(JSON.toJSONString(a));
    }

    /**
     * 选择排序<br>
     * j是i前一个值，倒序循环进行搬移数据<br>
     * a[i]待排序的数据要拿出来，否则会被移动数据覆盖掉
     * 
     * @param a
     */
    public static void myTest(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        // 待排序的元素 0第一个跳过
        for (int i = 1; i < a.length; i++) {

            for (int j = 0; j < i; j++) {

            }
        }
    }

    /**
     * 选择排序，a表示数组，n表示数组大小
     * 
     * @param a
     * @param n
     */
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }
}
