package com.code.design.pattern.behavioral.strategy;

import java.util.HashMap;

/**
 * @author tianwei
 * @since 2019-06-19 13:47
 */
public class CouponStrategyFactory {
    private static HashMap<String, PromotionStrategy> map = new HashMap<String, PromotionStrategy>();

    static {
        map.put("fanxian", new FanXianPromotionStrategy());
        map.put("lijian", new LiJianPromotionStrategy());
        map.put("manjian", new ManJianPromotionStrategy());
    }

    public PromotionStrategy getPromotionStrategy(String key) {
        return map.get(key);
    }
}
