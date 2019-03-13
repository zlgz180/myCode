package com.code.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序
 * 
 * @author tianwei
 * @since 2019-01-04 14:11
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[] { 2, 6, 4, 3, 1, 7 };
        // insertionSort(a, a.length);
        myTest(a);
        System.out.println(JSON.toJSONString(a));
    }

    /**
     * 插入排序<br>
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
            // 待排序的，先拿出来，避免数据乱了
            int tmp = a[i];
            // j是i前边那个数
            int j = i - 1;
            for (; j >= 0; j--) {
                // 待排序的比排序的小，就放到前边它前边，并移动
                if (tmp < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    // 不动
                    break;
                }
            }
            // 移动完了，插入数据
            a[j + 1] = tmp;
        }
    }

    /**
     * 插入排序，a表示数组，n表示数组大小
     * 
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 移动完了，插入数据
            a[j + 1] = value;
        }
    }
}
