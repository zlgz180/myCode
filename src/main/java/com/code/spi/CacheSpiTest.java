package com.code.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class CacheSpiTest {

    public static void main(String[] args) {
        ServiceLoader<Cache> serviceLoader = ServiceLoader.load(Cache.class);
        Iterator<Cache> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Cache cache = iterator.next();
            System.out.println(cache.getName());
            cache.put("user", "nana");
            System.out.println(cache.get("user", String.class));
        }
    }
}