package com.code.algorithm.leetcode.dp;

import java.util.HashMap;

/**
 * 动态规划
 *
 * @author tianwei
 * @since 2019-03-01 17:54
 */
public class DecisionProcess {
    HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * 有N阶台阶,每次迈1步或者2步,问有几种走法
     *
     * @param n
     * @return
     */
    public int function(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer tmp = map.get(n);
        if (tmp != null) {
            return tmp;
        }
        int a = 1;
        int b = 2;
        int j = 0;
        for (int i = 3; i < n; i++) {
            j = a + b;
            a = b;
            b = j;
        }
        return j;
    }

    /**
     * N阶台阶2种步数
     * 
     * @param n
     * @return
     */
    public int function2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer tmp = map.get(n);
        if (tmp != null) {
            return tmp;
        }
        int sum = function2(n - 1) + function2(n - 2);
        map.put(n, sum);
        return sum;
    }

    /**
     * N阶台阶n种步数
     *
     * @param n
     * @return
     */
    public int function3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer tmp = map.get(n);
        if (tmp != null) {
            return tmp;
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += function3(n - i);
        }
        map.put(n, sum);
        return sum;
    }
}
