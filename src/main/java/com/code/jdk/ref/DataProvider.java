package com.code.jdk.ref;

/**
 * 数据提供者接口
 */
public interface DataProvider<T> {
    /**
     * 获取数据函数
     */
    T getData();
}