package com.code.spi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapCache implements Cache {

    private final String name;

    private final ConcurrentMap<Object, Object> store;

    public ConcurrentMapCache() {
        this("defaultMapCache");
    }

    public ConcurrentMapCache(String name) {
        this(name, new ConcurrentHashMap<>(256), true);
    }

    public ConcurrentMapCache(String name, ConcurrentMap<Object, Object> store, boolean allowNullValues) {
        this.name = name;
        this.store = store;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        Object value = this.store.get(key);
        if (value != null && type != null && !type.isInstance(value)) {
            throw new IllegalStateException("Cached value is not of required type [" + type.getName() + "]: " + value);
        }
        return (T)value;
    }

    @Override
    public void put(Object key, Object value) {
        this.store.putIfAbsent(key, value);
    }

    @Override
    public void evict(Object key) {
        this.store.remove(key);
    }

    @Override
    public void clear() {
        this.store.clear();
    }

}