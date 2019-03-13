package com.code.algorithm.leetcode;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 
 * 注意:
 * 
 * num 的长度小于 10002 且 ≥ k。 num 不会包含任何前导零。 示例 1 :
 * 
 * 输入: num = "1432219", k = 3 输出: "1219" 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * 
 * 输入: num = "10200", k = 1 输出: "200" 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 */
public class RemoveKdigits {
    public static void main(String[] args) {
        // System.out.println(removeKdigits("65327", 2));

        System.out.println(removeKdigits("1173", 2));
    }

    /**
     * 每次删除第一个左边大于右边的值
     * 
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        for (int i = 0; i < k; i++) {
            boolean flag = false;
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    num = num.substring(0, j) + num.substring(j + 1);
                    flag = true;
                    break;
                }
            }
            // 如果都没有大数在前，就移除最后一位
            if (!flag) {
                num = num.substring(0, num.length() - 1);
            }
        }
        // 移除前缀是0的情况
        int y = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                y++;
            } else {
                break;
            }
        }
        if (y > 0) {
            num = num.substring(y);
        }
        if ("".equals(num)) {
            return "0";
        }
        return num;
    }
}
