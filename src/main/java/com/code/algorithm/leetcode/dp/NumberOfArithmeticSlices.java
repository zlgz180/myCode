package com.my.code.algorithm.leetcode.dp;

/**
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 *
 * @author tianwei
 * @since 2019/3/13 12:14
 */
public class NumberOfArithmeticSlices {
    private static final int[] A = { 1, 2, 3, 4, 5, 6, 7 };

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(A));

        System.out.println(numberOfArithmeticSlices2(A));
    }

    /**
     * 暴力破解
     *
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 2; j < A.length; j++) {
                if (isArrays(A, i, j)) {
                    sum++;
                } else {
                    continue;
                }
            }
        }
        return sum;
    }

    private static boolean isArrays(int[] A, int i, int j) {
        boolean flag = true;
        int tmp = A[i + 1] - A[i];
        // 判断是否是等差数列
        for (int k = i; k < j; k++) {
            if (tmp != A[k + 1] - A[k]) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 动态规划
     * 
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices2(int[] A) {
        int d1 = A[1] - A[0];
        int sum = 0;
        int dp = 0;
        for (int i = 2; i < A.length; i++) {
            int d2 = A[i] - A[i - 1];
            if (d1 == d2) {
                dp++;
                sum = sum + dp;
            } else {
                dp = 0;
            }
            d1 = d2;
        }
        return sum;
    }
}
