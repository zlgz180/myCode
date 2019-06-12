package com.notes.book.剑指offer第二版.code.chap4;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 */
public class MinNumberInRotateArray {
    /**
     * 二分查找法
     * 
     * @param array 旋转数组
     * @return 旋转数组的最小值
     */
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                // 在左半边
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                // 在右半边
                high = mid;
            } else {
                // 相等
                return array[mid];
            }
        }
        return array[low];
    }

    /**
     * 跟左边比，逻辑说不通，只能跟右边比
     * 
     * @param nums
     * @return
     */
    public static int minNumber(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + ((h - l) >> 1);
            // 在右边
            if (nums[mid] > nums[h]) {
                l = mid + 1;
            }
            // 已经在右边了，但是不知道是哪个做还是右
            if (nums[mid] < nums[h]) {
                h = mid;
            }
            // 暂时放弃二分查找
            if (nums[mid] == nums[h]) {
                h--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 1, 2, 3 };
        System.out.println(minNumberInRotateArray(nums));
        System.out.println(minNumber(nums));
    }
}
