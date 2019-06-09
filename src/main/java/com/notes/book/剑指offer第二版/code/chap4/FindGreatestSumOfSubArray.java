package com.notes.book.剑指offer第二版.code.chap4;

/**
 * 输入一个整型数组，数组里正负数都可能有，数组中的一个或者连续的多个整数组成一个子数组。 求所有子数组的和的最大值，要求时间复杂度为O(n)
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        FindGreatestSumOfSubArray demo = new FindGreatestSumOfSubArray();
        int[] nums = { -1, -2, -3, -4 };
        System.out.println(demo.findGreatestSumOfSubArray(nums));
    }

    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int maxSum = array[0];
        int curSum = array[0];
        for (int i = 1; i < array.length; i++) {
            // 如果小于0就换下一个
            if (curSum < 0) {
                curSum = array[i];
            } else {
                // 如果大于=0就加上
                curSum += array[i];
            }
            // 如果当前累加值比历史累加和都大，
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    /**
     * 动态规划，其实和上面是一样的代码...
     * 
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int maxSum = array[0];
        int curSum = array[0];
        for (int i = 1; i < array.length; i++) {
            // if (curSum + array[i] < array[i]),也就是if (curSum < 0)
            // 则curSum的结果是array[i]
            // 否则curSum的值是curSum + array[i]
            curSum = Math.max(curSum + array[i], array[i]);
            // 如果curSum > maxSum,则maxSum取curSum，否则maxSum = maxSum
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
