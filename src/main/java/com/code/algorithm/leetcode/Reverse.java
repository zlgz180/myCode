package com.code.algorithm.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123 输出: 321 示例 2:
 * 
 * 输入: -123 输出: -321 示例 3:
 * 
 * 输入: 120 输出: 21 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {
    public static int reverse(int x) {
        String newStr = "";
        // 符号
        if (x < 0) {
            newStr = "-";
            x = Math.abs(x);
        }
        String str = String.valueOf(x);
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '-') {
                break;
            }
            newStr += c;
        }

        long i = Long.parseLong(newStr);
        if (Math.pow(2, 31) - 1 < i) {
            return 0;
        }
        return (int) i;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 31) - 1);
//        System.out.println(reverse(-2147483648));
        // System.out.println(Integer.parseInt("3333333333333333333333333333333333333333333333333"));
    }
}
