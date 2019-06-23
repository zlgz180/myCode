package com.code.algorithm.sort;

import java.util.Arrays;

/**
 * //
 *
 * @author tianwei
 * @since 2019/2/26 18:24
 */
public class QuickSort5 {
    public static void main(String[] args) {
        // int[] arr = new int[] { 4, 7, 6, 5, 3, 2, 8, 1 };
        int[] arr = { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 用分治法递归数列的两部分
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    public static void sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int key = partition(a, start, end);
        sort(a, start, key - 1);
        sort(a, key + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int x = arr[end];
        int p = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= x) {
                p++;
                swap(arr, p, i);
            }
        }
        swap(arr, p + 1, end);
        return p + 1;
    }

    // 交换数组a中的a[i]和a[j]
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
