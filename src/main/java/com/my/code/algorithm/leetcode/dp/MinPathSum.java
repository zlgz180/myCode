package com.my.code.algorithm.leetcode.dp;

import java.util.HashMap;

/**
 * 给定一个包含非负整数的 m x n 网格， 请找出一条从左上角到右下角的路径， 使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入: <br>
 * [ [1,3,1], <br>
 * [1,5,1], <br>
 * [4,2,1] ] <br>
 * 输出: 7 <br>
 * 解释: 因为路径 1→3→1→1→1 的总和最小。<br>
 * 
 * @author tianwei
 * @since 2019-03-04 12:42
 */
public class MinPathSum {
    int maxRow = -1;
    int maxCol = -1;

    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        MinPathSum demo = new MinPathSum();
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        int i = demo.minPathSum(grid);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        maxRow = grid.length - 1;
        maxCol = grid[0].length - 1;
        if (maxRow <= 0 || maxCol <= 0) {
            return 0;
        }
        // 递归1 --
        // return help1(grid, maxRow, maxCol);
        // 递归2 ++
        // return help2(grid, 0, 0);
        // 地推 递归+map
        // return help3(grid, maxRow, maxCol);
        // 动态规划
        // return help4(grid);

        // 动态规划
        return help5(grid);
    }

    /**
     * 递归法
     *
     * @param arr
     * @param row
     * @param col
     * @return
     */
    public int help1(int[][] arr, int row, int col) {
        if (row == 0 && col == 0) {
            return arr[row][col];
        } else if (row != 0 && col == 0) {
            return arr[row][col] + help1(arr, row - 1, col);
        } else if (row == 0 && col != 0) {
            return arr[row][col] + help1(arr, row, col - 1);
        }
        return arr[row][col] + Math.min(help1(arr, row - 1, col), help1(arr, row, col - 1));
    }

    /**
     * 递归2
     *
     * @param arr
     * @return
     */
    public int help2(int[][] arr, int row, int col) {
        if (row == maxRow && col == maxCol) {
            return arr[maxRow][maxCol];
        }
        if (row < maxRow && col == maxCol) {
            return arr[maxRow][maxCol] + help2(arr, row + 1, col);
        }
        if (row == maxRow && col < maxCol) {
            return arr[maxRow][maxCol] + help2(arr, row, col + 1);
        }
        return arr[maxRow][maxCol] + Math.min(help2(arr, row, col + 1), help2(arr, row + 1, col));
    }

    /**
     * 递推法=递归+map
     * 
     * @param grid
     * @param row
     * @param col
     * @return
     */
    public int help3(int[][] grid, int row, int col) {
        String key = row + "," + col;
        Integer val = map.get(key);
        if (val != null) {
            return val;
        }
        int m = grid[0].length - 1;
        int n = grid.length - 1;
        if (row == m && col == n) {
            return grid[col][row];
        }
        if (row > m || col > n) {
            return Integer.MAX_VALUE;
        }
        int rightSum = help3(grid, row + 1, col);
        int downSum = help3(grid, row, col + 1);
        int result = Math.min(rightSum, downSum) + grid[col][row];
        // 递推法主要在这，把历史的和保存下来,通过上边的get来查询
        map.put(key, result);
        return result;
    }


    /**
     * 动态规划法 <br>
     * 从00开始向右向下找较小和(一定是历史和+当前和) <br>
     * 如果不是历史和，那就是贪心算法（不一定对） <br>
     * 如果没有最优解，那就是回溯算法
     * 
     * @param arr
     * @return
     */
    public int help4(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] sums = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    sums[i][j] = arr[i][j];
                    continue;
                }
                if (i != 0 && j == 0) {
                    sums[i][j] = arr[i][j] + sums[i - 1][j];
                    continue;
                }
                if (i == 0 && j != 0) {
                    sums[i][j] = arr[i][j] + sums[i][j - 1];
                    continue;
                }
                if (i != 0 && j != 0) {
                    sums[i][j] += Math.min(arr[i][j] + sums[i][j - 1], arr[i][j] + sums[i - 1][j]);
                }
            }
        }
        return sums[maxRow][maxCol];
    }

    /**
     * 拆解一下help4,先把边界都算出来，然后在算中间部分，然后取右下角
     * 
     * @param arr
     * @return
     */
    public int help5(int[][] arr) {
        if (arr == null) {
            return 0;
        }
        int row = arr.length;
        int col = arr[0].length;
        // 为了原数组不变，得开辟新数组记录每一步的历史和
        int[][] sums = new int[row][col];
        sums[0][0] = arr[0][0];
        // 第一列累加填充
        for (int i = 1; i < row; i++) {
            sums[i][0] = arr[i][0] + sums[i - 1][0];
        }
        // 第一行累加填充
        for (int i = 1; i < col; i++) {
            sums[0][i] = arr[0][i] + sums[0][i - 1];
        }
        // 从1,1中间开始填充
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                sums[i][j] += Math.min(arr[i][j] + sums[i][j - 1], arr[i][j] + sums[i - 1][j]);
            }
        }
        return sums[row - 1][col - 1];
    }
}
