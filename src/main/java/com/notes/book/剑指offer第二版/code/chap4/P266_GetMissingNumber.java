package com.notes.book.剑指offer第二版.code.chap4;

/**
 * 0~n中缺失的数字
 *
 * @author tianwei
 * @since 2019/6/11 21:27
 */
public class P266_GetMissingNumber {
    /**
     * 累加-data[]
     *
     * O(n) O(1)
     * 
     * @param data
     * @return
     */
    public static int getMissingNumber(int[] data) {
        int sum = 0;
        for (int i = 0; i <= data.length; i++) {
            sum += i;
        }
        for (int i = 0; i < data.length; i++) {
            sum -= data[i];
        }
        return sum;
    }

    /**
     * 序号和值不相等
     * 
     * @param data
     * @return
     */
    public static int getMissingNumber2(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != i) {
                return i;
            }
        }
        return data.length;
    }

    /**
     * 二分法 找值和序号不一致的数，值比序号大，在左边，值和序号相等在右边
     * 
     * @param data
     * @return
     */
    public static int getMissingNumber3(int[] data) {
        int l = 0;
        int r = data.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (data[mid] != mid) {
                return mid;
            }
            if (data[mid] > mid) {
                // 左边
                r = mid - 1;
            } else if (data[mid] == mid) {
                // 右边
                l = mid + 1;
            }
        }
        return data.length;
    }

    public static void main(String[] args) {
        int[] data1 = new int[] { 0, 1, 2, 3, 4, 5 }; // 6
        int[] data2 = new int[] { 0, 1, 3, 4, 5 }; // 2
        int[] data3 = new int[] { 1, 2 }; // 0
        System.out.println(getMissingNumber3(data1));
        System.out.println(getMissingNumber3(data2));
        System.out.println(getMissingNumber3(data3));
    }
}