package com.my.code.algorithm.homework.day2;

/**
 * @author tianwei
 * @since 2019-02-26 17:52
 */
public class Recursive {
    public static void main(String[] args) {
        System.out.println(demo2(3));
    }

    /**
     * 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2)
     */
    public static int demo1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return demo1(n - 1) + demo1(n - 2);
    }

    /**
     * n的阶乘
     *
     * @param n
     */
    public static int demo2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return demo2(n - 1) * n;
    }


}
