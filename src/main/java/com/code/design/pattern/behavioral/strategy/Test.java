package com.code.design.pattern.behavioral.strategy;

/**
 * Created by geely
 */
public class Test {

    private static CouponStrategyFactory factory = new CouponStrategyFactory();

    public static void main2(String[] args) {
        PromotionActivity promotionActivity618 = new PromotionActivity(new LiJianPromotionStrategy());
        PromotionActivity promotionActivity1111 = new PromotionActivity(new FanXianPromotionStrategy());

        promotionActivity618.executePromotionStrategy();
        promotionActivity1111.executePromotionStrategy();
    }

    public static void main(String[] args) {
        factory.getPromotionStrategy("manjian");
        factory.getPromotionStrategy("manjian").doPromotion();
        factory.getPromotionStrategy("fanxian").doPromotion();
        factory.getPromotionStrategy("lijian").doPromotion();
    }
}
