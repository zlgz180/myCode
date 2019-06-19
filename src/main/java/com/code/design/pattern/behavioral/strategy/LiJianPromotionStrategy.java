package com.code.design.pattern.behavioral.strategy;

/**
 * Created by geely
 */
public class LiJianPromotionStrategy extends BaseStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("立减促销,课程的价格直接减去配置的价格");
    }

    @Override protected void preDo() {

    }

    @Override protected void afterDo() {

    }
}
