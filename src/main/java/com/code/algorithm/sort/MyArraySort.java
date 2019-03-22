package com.code.algorithm.sort;

import java.util.Arrays;

/**
 * @author tianwei
 * @since 2019-03-22 20:52
 */
public class MyArraySort {
    public static void main(String[] ttt) {
        int[] arr = { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
        //快速排序
        fastSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        System.out.println(find(arr, arr[arr.length - 1]));
    }

    /**
     * 二分查找
     *
     * @param arr
     * @param n
     * @return
     */
    public static int find(int[] arr, int n) {
        if (arr == null) {
            return -1;
        }
        int mid = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            //            mid = (right + left) / 2;
            mid = left + ((right - left) >> 1);
            if (arr[mid] == n) {
                return mid;
            }
            if (arr[mid] > n) {
                right = mid - 1;
            }
            if (arr[mid] < n) {
                left = mid + 1;
            }
        }
        return mid;
    }

    public static void fastSort(int[] arr, int start, int end) {
        if (arr == null || end <= start) {
            return;
        }
        int mid, l = start, r = end, key = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= key) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= key) {
                l++;
            }
            arr[r] = arr[l];
        }
        mid = l;
        arr[l] = key;
        fastSort(arr, start, mid - 1);
        fastSort(arr, mid + 1, end);
    }
}
