package com.code.jdk.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author tianwei
 * @since 2018-06-26 18:32
 */
public class GuavaCacheDemo {
    public static void main(String[] args) throws ExecutionException {
        Cache<Object, Object> cache = CacheBuilder.newBuilder().concurrencyLevel(2).build();
        cache.put(1,"tianwei");
        Object o = cache.get(1, new Callable<Object>() {
            @Override public Object call() throws Exception {
                return null;
            }
        });
        System.out.println(o);
    }
}
