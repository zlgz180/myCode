package com.notes.book.剑指offer第二版.code.chap4;

/**
 * Created by ryder on 2017/7/5. 剪绳子
 */
public class P96_CuttingRope {
    public static int maxCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        if (length == 4) {
            return 4;
        }
        int[] dp = new int[length + 1];

        return 0;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            System.out.println("长度为" + i + "的最大值->" + maxCutting(i));
        }
    }
}