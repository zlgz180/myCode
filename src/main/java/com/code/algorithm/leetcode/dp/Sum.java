package com.code.algorithm.leetcode.dp;

/**
 * @author tianwei
 * @since 2019-03-22 22:42
 */
public class Sum {
    public static void main(String[] args) {
        System.out.println(sum(10000000));
    }

    /**
     * 求1+n的和
     */
    public static int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
