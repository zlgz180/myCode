package com.code.jdk.jvm;

import java.util.LinkedList;

/**
 * @author tianwei
 * @since 2019-03-18 10:49
 */
public class jvm {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            int[] ints = new int[1024 * 1124];
            Thread.sleep(100);
        }

        LinkedList<Integer> integers = new LinkedList<>();
        Integer integer1 = integers.get(0);
        integers.get(1);
        for (Integer integer : integers) {

        }
    }
}
