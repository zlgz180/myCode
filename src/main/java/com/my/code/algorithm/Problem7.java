package com.my.code.algorithm;

/**
 * 2分查找
 * 
 * @author tianwei
 * @since 2018-07-04 10:38
 */
public class Problem7 {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7 };
        int t = splitFind(array, 4);
    }

    private static int splitFind(int[] array, int target) {
        int start = 0;
        int last = array.length - 1;

        while (start <= last) {
            int mid = (start + last) / 2;
            if (target == array[mid]) {
                return mid;
            }
            if (target < array[mid]) {

            }
            if (target > array[mid]) {

            }
        }

        return 0;
    }

}
