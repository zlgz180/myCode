package com.code.algorithm.leetcode;

import java.util.*;

/**
 * 求斐波那契数列的第N项 n<=39
 *
 * @author tianwei
 * @since 2019-03-12 22:26
 */
public class Test {
    public static void main(String[] args) {
        // System.out.println(sum + ";" + bengin(39));
        System.out.println(sum2 + ";" + bengin2(39));
        System.out.println(bengin6(39));
        // System.out.println(bengin3(390));

        // System.out.println(bengin4(39));

        Integer[] mem2 = new Integer[40];
        System.out.println(bengin7(39, mem2));
        int[] ints = new int[2];
        ints[2 - 1] = 3;
        System.out.println(ints[2 - 1]);
    }

    private static int sum = 0;

    private static int sum2 = 0;

    public static int bengin(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        sum = sum + 1;
        return bengin(n - 1) + bengin(n - 2);
    }

    private static HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * @param n
     * @return
     */
    public static int bengin2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        sum2 = sum2 + 1;
        Integer t1 = map.get(n - 1);
        if (t1 == null) {
            t1 = bengin2(n - 1);
            map.put(n - 1, t1);
        }
        Integer t2 = map.get(n - 2);
        if (t2 == null) {
            t2 = bengin2(n - 2);
            map.put(n - 2, t2);
        }
        return t1 + t2;
    }

    public static int bengin3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    /**
     * 跳台阶
     *
     * @param n
     * @return
     */
    public static int bengin4(int n) {
        if (n <= 2) {
            return n;
        }
        int t1 = 2;
        int t2 = 1;
        int result = 1;
        for (int i = 2; i < n; i++) {
            result = t1 + t2;
            t2 = t1;
            t1 = result;
        }
        return result;
    }

    /**
     * 跳n台阶,每次跳n阶
     *
     * @param n
     * @return
     */
    public static int bengin5(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i--) {
            dp[2] = dp[i] + dp[i - 1];
        }
        return dp[n - 1];
    }

    private static int n = 39;
    private static Integer[] mem = new Integer[n + 1];

    /**
     * @param n
     * @return
     */
    public static int bengin6(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (mem[n] == null) {
            mem[n] = bengin6(n - 1) + bengin6(n - 2);
        }
        return mem[n];
    }

    /**
     * @param n
     * @return
     */
    public static int bengin7(int n, Integer[] mem) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (mem[n] == null) {
            mem[n] = bengin6(n - 1) + bengin6(n - 2);
        }
        return mem[n];
    }

    private static Integer[][] dp = new Integer[50][50];

    /**
     * 矩阵nums,从左上角走到右下角最多有多少种走法
     *
     * @param nums
     * @return
     */
    public static int bengin8(int[][] nums, int col, int row) {
        if (nums == null || nums[0] == null) {
            return 0;
        }
        if (col == 0 || row == 0) {
            return 1;
        }
        if (dp[col][row] == null) {
            dp[col][row] = bengin8(nums, col - 1, row) + bengin8(nums, col, row - 1);
        }
        return dp[col][row];
    }

    public static int bengin8(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(k, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int) o2 - (int) o1;
            }
        });
        for (int num : nums) {
            queue.add(num);
        }
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            queue.remove(next);
        }
        return queue.poll();
    }

    public static void bengin9(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i + j == k) {
                    // return i,j
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            boolean remove = set.remove(i);
            int t1 = nums[k] - nums[i];
            if (set.contains(t1)) {
                for (int j = 0; j < nums.length; j++) {

                }
            }
        }
    }
}
