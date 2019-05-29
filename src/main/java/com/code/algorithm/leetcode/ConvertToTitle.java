package com.code.algorithm.leetcode;

public class ConvertToTitle {

    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     * 
     * 例如，
     * 
     * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB ... 示例 1:
     * 
     * 输入: 1 输出: "A" 示例 2:
     * 
     * 输入: 28 输出: "AB" 示例 3:
     * 
     * 输入: 701 输出: "ZY"
     * 
     * @param n
     * @return
     */
    public static String convertToTitle2(int n) {
        char[] a = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z' };
        // A=65 Z=90
        String result = "";
        while (n > 0) {
            n--;
            result = a[n % 26] + result;
            n = n / 26;
        }
        return result;
    }

    public static String convertToTitle(int n) {
        char[] a = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z' };// 表
        String res = "";
        while (n > 0) {
            n--;// 要先减一才能找到对应的字母
            res = a[n % 26] + res;
            n = n / 26;
        }
        return res;
    }

    public static void main(String[] args) {
        char a = 'Z';

        // System.out.println(1 % 26);
        // System.out.println((int) a);

//        System.out.println(convertToTitle2(701));

        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum *= 26;// 技巧：第一个刚好被 0 搞掉
            sum += (int) s.charAt(i) - (int) 'A' + 1;
        }
        return sum;
    }
}
