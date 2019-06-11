package com.notes.book.剑指offer第二版.code.chap4;

/**
 * Created with IntelliJ IDEA. Author: ryder Date : 2017/8/1 Time : 20:58
 * Description:连续子数组的最大和
 **/
public class P218_GreatestSumOfSubarrays {

    public static int findGreatestSumOfSumArrays(int[] data) {
        if (data == null) {
            return 0;
        }
        // 当前最大和
        int dp = data[0];
        // 历史最大和
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            dp = Math.max(data[i] + dp, data[i]);
            max = Math.max(dp, max);
        }
        return max;
    }

    public static int findGreatestSumOfSumArrays3(int[] data) {
        if (data == null) {
            return 0;
        }
        // 当前最大和
        int dp = data[0];
        // 历史最大和
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (dp < 0) {
                dp = data[i];
            } else {
                dp += data[i];
            }
            max = Math.max(dp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = { 2, 3, -6, 4, 6, 2, -2, 5, -9 };
        // int[] data = { -1, -2, -3, -4, -5, -6, -7 };
        // int[] data = { 3, -2, 6, 9, -5 };
        System.out.println(findGreatestSumOfSumArrays3(data));
    }

    public static int findGreatestSumOfSumArrays2(int[] data) {
        // 给定一个足够小的最大值
        int SUM = -100000;
        for (int i = 0; i < data.length; i++) {
            int subOfArr = 0; // 临时最大值
            for (int j = i; j < data.length; j++) {
                System.out.println(data[j]);
                subOfArr += data[j];
                if (subOfArr > SUM) {
                    SUM = subOfArr;
                }
            }
        }
        return SUM;
    }

}
