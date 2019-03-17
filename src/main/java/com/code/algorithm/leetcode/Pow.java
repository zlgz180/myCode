package com.code.algorithm.leetcode;

/**
 * @author tianwei
 * @since 2019-03-14 0:36
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(pow(2, 4));
        System.out.println(pow2(2, 4));
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        for (int i = 2; i < n; i++) {
            x *= x;
        }
        return x;
    }

    public static double pow2(double x, int n) {
        if (n <= 0) {
            return x;
        }
        return pow2(x, n - 2) * pow2(x, n - 3);
    }
}
