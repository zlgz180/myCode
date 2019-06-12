package com.notes.book.剑指offer第二版.code.chap4;

/**
 * 数字在排序数组中出现的次数
 * 
 * @author tianwei
 * @since 2019/6/11 18:18
 */
public class NumberOfK {
    // 遍历的话时间复杂度为o(n)
    // 考虑到数组是排序好的，可使用二分法，时间复杂度o(logn)
    public static int getNumberOfK(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1 && nums[0] != k) {
            return 0;
        }
        // 先找到k所在序号
        int l = 0;
        int r = nums.length - 1;
        int kIndex = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == k) {
                kIndex = mid;
                break;
            }
            if (nums[mid] < k) {
                l = mid + 1;
            }
            if (nums[mid] > k) {
                r = mid - 1;
            }
        }
        if (kIndex == -1) {
            return 0;
        }
        // k的最左侧
        int min = kIndex;
        while (min >= 1 && nums[min] == nums[min - 1]) {
            min--;
        }
        // k的最右侧
        int max = kIndex;
        while (max <= nums.length - 1 && nums[max] == nums[max - 1]) {
            max++;
        }
        return max - min;
    }



    public static void main(String[] args) {
        int[] data1 = new int[] { 1, 2, 3, 3, 3, 3, 5, 6 };
        int[] data2 = new int[] { 1, 2, 3, 3, 3, 3, 4, 5 };
        int[] data3 = new int[] { 3, 3, 3, 3, 3, 3, 3, 3 };
        System.out.println(getNumberOfK(data1, 4));
        System.out.println(getNumberOfK(data2, 3));
        System.out.println(getNumberOfK(data3, 3));
    }
}
