package com.code.design.pattern.behavioral.strategy;

/**
 * Created by geely
 */
public class ManJianPromotionStrategy extends BaseStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减促销,满200-20元");
    }

    @Override protected void preDo() {

    }

    @Override protected void afterDo() {

    }
}
