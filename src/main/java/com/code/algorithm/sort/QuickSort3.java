package com.code.algorithm.sort;

public class QuickSort3 {

    public static void main(String[] args) {
        // int[] a = { 12, 20, 5, 16, 15, 1, 30, 45, 23, 9 };
        int[] a = { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
        int start = 0;
        int end = a.length - 1;
        quickSort_2(a, start, end);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 挖坑填数+分治
     *
     * @param data
     * @param start
     * @param end
     */
    public static void quickSort_2(int[] data, int start, int end) {
        if (data == null || start >= end) {
            return;
        }
        int low = start, high = end;
        // 轴
        int pivotKey = data[start];
        while (low < high) {
            // 找到从右到左第一个比key大的值
            while (low < high && data[high] >= pivotKey) {
                high--;
            }
            if (low < high) {
                data[low++] = data[high];
            }
            while (low < high && data[low] <= pivotKey) {
                low++;
            }
            if (low < high) {
                data[high--] = data[low];
            }
        }
        data[low] = pivotKey;
        quickSort_2(data, start, low - 1);
        quickSort_2(data, low + 1, end);
    }

    /**
     * 快速排序算法
     * 
     * @param data
     * @param start
     * @param end
     */
    public void quickSort_1(int[] data, int start, int end) {
        if (data == null || start < 0 || end > data.length - 1) {
            throw new IllegalArgumentException("Invalid Parameters");
        }
        if (start == end) {
            return;
        }
        int index = partition(data, start, end);
        if (index > start) {
            quickSort_1(data, start, index - 1);
        }
        if (index < end) {
            quickSort_1(data, index + 1, end);
        }
    }

    private int partition(int[] data, int start, int end) {
        int index = start + (int) (Math.random() * (end - start + 1));
        swap(data, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }
        swap(data, small + 1, end);
        return small + 1;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
