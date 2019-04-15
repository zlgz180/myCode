package com.code.jdk.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;

/**
 * @author tianwei
 * @since 2018-06-26 18:32
 */
public class GuavaCacheDemo {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumWeight(1000)
                .weigher(new Weigher<String, String>() {
                    @Override
                    public int weigh(String key, String value) {
                        return key.length();
                    }
                }).expireAfterAccess(10, TimeUnit.MINUTES).build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return key + "cache";
                    }
                });
        cache.put("test", "23333");
        System.out.println(cache.get("test"));
        System.out.println(cache.get("scj"));

        // output
        // 2333
        // scjcache
    }
}
