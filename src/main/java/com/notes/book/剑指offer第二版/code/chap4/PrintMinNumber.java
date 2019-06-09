package com.notes.book.剑指offer第二版.code.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 */
public class PrintMinNumber {
    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";

        List<Integer> list = new ArrayList<>();
        for (int a : numbers) {
            list.add(a);
        }
        Collections.sort(list, (a, b) -> (a + "" + b).compareTo((b + "" + a)));
        StringBuilder sb = new StringBuilder();
        for (int a : list) {
            sb.append(a);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 32, 1, 2, 0 };
        String result = new PrintMinNumber().printMinNumber(nums);
        System.out.println(result);
    }
}
