package com.code.algorithm.sort;

import java.util.Arrays;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = { 5, 4, 3, 1, 2, 7 };
        mergeSort(data);
        System.out.print("数组归并排序：\t" + Arrays.toString(data));
    }

    // 归并排序算法, a是数组，n表示数组大小
    public static void mergeSort(int[] a) {
        mergeSortInternally(a, 0, a.length - 1);
    }

    // 递归调用函数
    private static void mergeSortInternally(int[] a, int l, int r) {
        // 递归终止条件
        if (a == null || a.length <= 1 || l >= r) {
            return;
        }
        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int mid = l + (r - l) / 2;
        // 分治递归
        mergeSortInternally(a, l, mid);
        mergeSortInternally(a, mid + 1, r);
        // 将A[l...mid]和A[mid+1...r]合并为A[;...r]
        merge(a, l, mid, r);
    }

    /**
     *
     * @param nums 数组
     * @param l 左序号
     * @param mid 中间序号
     * @param r 有序号
     */
    private static void merge(int[] nums, int l, int mid, int r) {
        // 初始化变量i, j, k
        int i = l;
        int j = mid + 1;
        int k = 0;
        // 申请一个大小跟a[p...r]一样的临时数组
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = mid;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = nums[start++];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r - l; ++i) {
            nums[l + i] = tmp[i];
        }
    }
}
