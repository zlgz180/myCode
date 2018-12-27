package com.my.code.Thead;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class RateLimiterDemo {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(2.0);
        // 批量调用
        for (int i = 0; i < 10; i++) {
            double acquire = limiter.acquire();
            System.out.println("获取令牌成功!,消耗=" + acquire);
        }
    }
}
