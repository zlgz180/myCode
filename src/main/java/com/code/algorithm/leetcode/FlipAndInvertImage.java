package com.code.algorithm.leetcode;

/**
 * @author tianwei
 * @since 2019-06-04 20:14
 */
public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] a = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        flipAndInvertImage(a);
    }

    /**
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     *
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     *
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     *
     * 示例 1:
     *
     * 输入: [[1,1,0],[1,0,1],[0,0,0]] 输出: [[1,0,0],[0,1,0],[1,1,1]] 解释: 首先翻转每一行:
     * [[0,1,1],[1,0,1],[0,0,0]]； 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]] 示例 2:
     *
     * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]] 输出:
     * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] 解释: 首先翻转每一行:
     * [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]； 然后反转图片:
     * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] 说明:
     *
     * 1 <= A.length = A[0].length <= 20 0 <= A[i][j] <= 1
     *
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A[0] == null) {
            return null;
        }
        // 水平翻转
        for (int i = 0; i < A.length; i++) {
            int[] tmp = new int[A.length];
            for (int j = 0; j < A[i].length; j++) {
                tmp[A.length - 1 - j] = A[i][j];
            }
            A[i] = tmp;
        }

        // 图片反转
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] ^= 1;
            }
        }
        return A;
    }
}
