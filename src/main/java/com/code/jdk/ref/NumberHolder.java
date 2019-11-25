package com.code.jdk.ref;

import groovy.transform.ToString;

/**
 * 数字支撑类
 */
@ToString
public class NumberHolder<T extends Number> {
    /**
     * 通用取值
     */
    private T value;

    /**
     * 构造函数
     */
    public NumberHolder() {}

    /**
     * 构造函数
     */
    public NumberHolder(T value) {
        this.value = value;
    }

    /**
     * 打印取值函数
     */
    public static <T extends Number> void printValue(GenericHolder<T> holder) {
        System.out.println(holder.getValue());
    }
}