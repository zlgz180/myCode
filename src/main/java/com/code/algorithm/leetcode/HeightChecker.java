package com.code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author tianwei
 * @since 2019-06-04 20:37
 */
public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int[] tmp = heights.clone();
        Arrays.sort(tmp);
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != tmp[i]) {
                result++;
            }
        }
        return result;
    }

    public static boolean judgeSquareSum(int c) {
        double sqrt = Math.sqrt(c);
        int tmp = (int) sqrt;
        int[] ints = new int[(int) sqrt + 1];
        for (int i = 0; i <= tmp; i++) {
            ints[i] = i * i;
        }

        HashSet<Integer> set = new HashSet();
        for (int i : ints) {
            set.add(i);
        }
        for (Integer i : ints) {
            if (set.contains(c - i)) {
                return true;
            }
        }
        return false;
    }

    public static int mySqrt(int x) {
        long l = 0;
        long r = x;
        while (l <= r) {
            long mid = l + ((r - l) >> 1);
            long tmp = mid * mid;
            if (tmp == x) {
                return (int) mid;
            }
            if (tmp > x) {
                r = mid - 1;
            }
            if (tmp < x) {
                l = mid + 1;
            }
        }
        return (int) r;
    }

    public static boolean isPerfectSquare2(int num) {
        long l = 1;
        long r = num;
        while (l <= r) {
            long mid = l + ((r - l) >> 1);
            // int mid = (h + l) / 2;
            long tmp = mid * mid;
            if (tmp == num) {
                return true;
            }
            if (tmp < num) {
                l = mid + 1;
            }
            if (tmp > num) {
                r = mid - 1;
            }
        }
        return false;
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        if (num < 4) {
            return false;
        }
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            long temp = mid * mid;
            if (temp == num) {
                return true;
            }
            if (temp < num) {
                left = mid + 1;
            }
            if (temp > num) {
                right = mid - 1;
            }
        }
        return false;
    }

    public static double myPow(double x, int n) {
        double result = x;
        if (n == 0) {
            return 1;
        }
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        for (int i = 1; i < n; i++) {
            result *= x;
        }
        return flag ? 1 / result : result;
    }

    /**
     * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
     * <p>
     * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i < j 且有 (time[i] + time[j])
     * % 60 == 0。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[30,20,150,100,40] 输出：3 解释：这三对的总持续时间可被 60 整数： (time[0] = 30, time[2] =
     * 150): 总持续时间 180 (time[1] = 20, time[3] = 100): 总持续时间 120 (time[1] = 20,
     * time[4] = 40): 总持续时间 60 示例 2：
     * <p>
     * 输入：[60,60,60] 输出：3 解释：所有三对的总持续时间都是 120，可以被 60 整数。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= time.length <= 60000 1 <= time[i] <= 500
     *
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1
     * 到 n 的 min(ai, bi) 总和最大。
     *
     * 示例 1:
     *
     * 输入: [1,4,3,2]
     *
     * 输出: 4 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4). 提示:
     *
     * n 是正整数,范围在 [1, 10000]. 数组中的元素范围在 [-10000, 10000].
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        return 0;
    }

    /**
     * int sum1 = 0; int sum2 = 0;
     *
     * for (int i=0; i<numsSize; i++) { sum1 += nums[i]; }
     *
     * for (int i=0; i<numsSize+1; i++) { sum2 += i; }
     *
     * return sum2-sum1;
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            sum += i;
        }
        int sum2 = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum2 += i;
        }
        return sum - sum2;
    }

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 12 输出: 3 解释: 12 = 4 + 4 + 4.
     *
     * 示例 2:
     * <p>
     * 输入: n = 13 输出: 2 解释: 13 = 4 + 9.
     *
     * @param n
     * @return 12
     */
    public static int numSquares(int n) {
        // 1 4 9 16
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int i = 1;
        while (n >= sum) {
            int tmp = i * i;
            int size = list.size();
            if (size > 0 && list.get(size - 1) + tmp > n) {
                break;
            }
            sum += tmp;
            list.add(tmp);
            i++;
        }
        int res = 0;
        int len = list.size() - 1;
        while (n >= 0 && len >= 0) {
            n = n - list.get(len);
            if (n == 0) {
                res++;
                return res;
            } else if (n > 0) {
                len--;
                res++;
            } else {
                len--;
            }
        }
        return res;
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) {
            return 0;
        }
        int res=Integer.MAX_VALUE
        for (int coin : coins) {
            if (amount > coin) {
                //不够扣的，换一个
                continue;
            }
            int tmp = coinChange(coins, amount - coin);

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] heights = { 1, 1, 4, 2, 1, 3 };
        // heightChecker(heights);

        // judgeSquareSum(4);

        // isPerfectSquare2(16);
        // System.out.println(mySqrt(19));
        // System.out.println(myPow(2, -2));

        System.out.println(numSquares(12));
    }
}
