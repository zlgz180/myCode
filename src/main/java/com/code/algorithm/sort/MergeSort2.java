package com.code.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * 稳定排序，时间复杂度nlogn 空间复杂度n
 * 
 * @author tianwei
 * @since 2019/6/10 15:32
 */
public class MergeSort2 {
    // 数组二路归并，时间o(nlogn)，空间o(n)，稳定
    public static int[] mergeSort(int[] data) {
        if (data == null || data.length <= 1) {
            return data;
        }
        mergeSortCore(data, 0, data.length - 1);
        return data;
    }

    // 对data[start~mid]，data[mid+1~end]归并
    // 典型的分治结构：结束条件+分治+和
    public static void mergeSortCore(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSortCore(data, start, mid);
        mergeSortCore(data, mid + 1, end);
        mergeSortMerge(data, start, mid, end);
    }

    public static void mergeSortMerge(int[] data, int start, int mid, int end) {
        if (end == start) {
            return;
        }
        int[] temp = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int tempIndex = 0;
        while (left <= mid && right <= end) {
            if (data[left] < data[right]) {
                temp[tempIndex++] = data[left++];
            } else {
                temp[tempIndex++] = data[right++];
            }
        }
        //
        while (left <= mid) {
            temp[tempIndex++] = data[left++];
        }
        //
        while (right <= end) {
            temp[tempIndex++] = data[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            data[start + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] data = { 5, 4, 3, 1, 2 };
        mergeSort(data);
        System.out.print("数组归并排序：\t" + Arrays.toString(data));
    }
}
