package com.code.jdk.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class GuavaRateLimiterDemo {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(2.0, 3, TimeUnit.SECONDS);
        // 批量调用
        for (int i = 0; i < 10; i++) {
            double acquire = limiter.acquire();
            System.out.println("获取令牌成功!,消耗=" + acquire);
        }
    }
}
