package com.code.algorithm.sort;

import java.util.Arrays;

/**
 * //
 *
 * @author tianwei
 * @since 2019/2/26 18:24
 */
public class QuickSort {
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
        // 取第一个位置的元素作为基准元素
        int left = start;
        int right = end;
        // 坑的位置，初始等于pivot的位置
        int index = start;
        // 大循环在左右指针重合或者交错时结束
        while (right >= left) {
            // right指针从右向左进行比较
            while (right >= left) {
                if (arr[right] < arr[start]) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            // left指针从左向右进行比较
            while (right >= left) {
                if (arr[left] > arr[start]) {
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = arr[start];
        return index;
    }
}
