package com.code.jdk.ref;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

/**
 * 通用支撑类
 */
public class GenericHolder<T> {
    /**
     * 通用取值
     */
    private T value;

    /**
     * 构造函数
     */
    public GenericHolder() {}

    /**
     * 构造函数
     */
    public GenericHolder(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    /**
     * 浅拷贝函数
     */
    public static <T> T shallowCopy(Object source, Class<T> clazz) throws Exception {
        // 判断源对象
        if (Objects.isNull(source)) {
            return null;
        }

        // 新建目标对象
        T target;
        try {
            target = clazz.newInstance();
        } catch (Exception e) {
            throw new Exception("新建类实例异常", e);
        }

        // 拷贝对象属性
        BeanUtils.copyProperties(source, target);

        // 返回目标对象
        return target;
    }


    /** 打印取值函数 */
    public static void printValue(GenericHolder<?> holder) {
        System.out.println(holder.getValue());
    }
    /** 主函数 */
    public static void main(String[] args) {
        printValue(new GenericHolder<>(12345));
        printValue(new GenericHolder<>("abcde"));
    }
}