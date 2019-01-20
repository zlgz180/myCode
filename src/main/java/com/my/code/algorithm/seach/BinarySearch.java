package com.my.code.algorithm.seach;

import com.alibaba.fastjson.JSON;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{2, 6, 4, 3, 1, 7};
        // bubbleSort(a, a.length);
        System.out.println(JSON.toJSONString(a));
    }

    public long sort(int[] a, int val) {
        int low = 0;
        int high = a.length - 1;
        while (high >= low) {
            int mid = low + (high - low) / 2;
//            long mid = (high + low) / 2;
            if (a[mid] == val) {
                return mid;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else if (a[mid] > val) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public long bSeach(int[] t, int n, int val) {
        return sd(t, n, val, 0, n - 1);
    }

    public long sd(int[] t, int n, int val, int low, int high) {
        int mid = low + (high - low) >> 1;
        if (t[mid] == val) {
            return mid;
        }
        if (t[mid] < val) {
            sd(t, n, val, low, high - 1);
        } else {
            sd(t, n, val, low + 1, high);
        }
        return -1;
    }
}
