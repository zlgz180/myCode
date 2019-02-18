package com.my.code.algorithm.leetcode;

import java.util.HashSet;

/**
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4] 输出：[2,4,3,1] 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000 0 <= A[i] <= 5000
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] t1 = new int[] { 3, 2, 1, 5, 4, 2, 5 };
        int[] t2 = new int[] { 3, 2, 1, 5, 4, 2, 5 };
        // System.out.println(Arrays.toString(intersection(t1, t2)));

        char[] chars = "1234".toCharArray();
        reverseString(chars);
        System.out.println(chars);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet set = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int nu1 = nums1[i];
                if (!set.contains(nu1) && nu1 == nums2[j]) {
                    set.add(nums1[i]);
                }
            }
        }
        int[] newNums = new int[set.size()];
        int sum = 0;
        for (Object o : set) {
            newNums[sum++] = (int) o;
        }
        return newNums;
    }

    public static void reverseString(char[] s) {
        // 找到中位符
        int subNum = (s.length % 2 == 0) ? s.length / 2 : s.length / 2 + 1;
        int j = s.length - 1;
        for (int i = 0; i < subNum; i++) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            j--;
        }
    }

    public static void reverseString2(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
    }
}
