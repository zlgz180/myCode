package com.code.spi;

public interface Cache {

    String getName();

    <T> T get(Object key, Class<T> type);

    void put(Object key, Object value);

    void evict(Object key);

    void clear();

}