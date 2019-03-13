package com.code.algorithm.sort;

import com.alibaba.fastjson.JSON;

import groovy.util.logging.Slf4j;

/**
 * 冒泡排序
 * 
 * @author tianwei
 * @since 2018-12-27 12:26
 */
@Slf4j
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[] { 2, 6, 4, 3, 1, 7 };
        // bubbleSort(a, a.length);
        myTest(a);
        System.out.println(JSON.toJSONString(a));
    }

    /**
     * 注意事项<br>
     * 1.数据越界<br>
     * 2.i是控制j的最大值的<br>
     * 
     * @param a
     */
    public static void myTest(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                try {
                    if (a[j] > a[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    } else {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("异常i=" + i + ",j=" + j);
                }
            }
        }
    }

    /**
     * 冒泡排序，a 表示数组，n 表示数组大小</br>
     * 0~n 0~n-1 0~n-2 0~n-3
     *
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag) {
                break; // 没有数据交换，提前退出
            }
        }
    }

}
