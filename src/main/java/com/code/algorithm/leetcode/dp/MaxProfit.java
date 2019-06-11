package com.code.algorithm.leetcode.dp;

/**
 * @author tianwei
 * @since 2019-06-11 20:59
 */
public class MaxProfit {

    /**
     * Leetcode 121. 买卖股票的最佳时机 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        // 7,1,5,3,6,4
        int maxProfit = -1;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    /**
     * Leetcode 122. 买卖股票的最佳时机 II 这次改成股票可以买卖多次, 但是你必须要在出售股票之前把持有的股票卖掉。 示例 1: 输入:
     * [7,1,5,3,6,4] 输出: 7 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出,
     * 这笔交易所能获得利润 = 5-1 = 4 。 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出,
     * 这笔交易所能获得利润 = 6-3 = 3 。
     * 
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        // 7,1,5,3,6,4
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                maxProfit += prices[i] - minPrice;
            }
            minPrice = prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(nums));
        System.out.println(maxProfit2(nums));
    }
}
