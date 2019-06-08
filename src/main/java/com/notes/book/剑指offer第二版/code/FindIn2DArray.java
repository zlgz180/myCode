package com.notes.book.剑指offer第二版.code;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * @author tianwei
 * @since 2019-06-08 10:45
 */
public class FindIn2DArray {

    public static boolean find1(int target, int[][] array) {
        if (array == null || array.length <= 0) {
            return false;
        }
        for (int[] row : array) {
            for (int col : row) {
                if (col == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 每一行都二分查找
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find2(int target, int[][] array) {
        if (array == null || array.length <= 0) {
            return false;
        }
        for (int[] row : array) {
            int l = 0;
            int h = row.length - 1;
            while (h >= l) {
                int mid = l + ((h - l) >> 1);
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] > target) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }

    /**
     * 更推荐的做法，由于矩阵从上到下递增，从左到右递增。
     *
     * 总是和二维矩阵的右上角元素比较（对称地，左下角也可以）
     * 
     * 如果目标比右上角的大，删除该行，行指针向下移动；如果比右上角的小，删除该列，列指针左移
     */
    public static boolean find3(int target, int[][] array) {
        int sumCol = array[0].length;
        int sumrow = array.length;

        // 从左下角数，如果比当前值大，指针向右，如果比当前值小，指针向上移
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col <= sumCol - 1) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        int target = 15;
        System.out.println(find3(target, nums));
    }
}
