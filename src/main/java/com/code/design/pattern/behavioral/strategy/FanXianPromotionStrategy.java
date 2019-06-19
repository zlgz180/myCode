package com.code.design.pattern.behavioral.strategy;

/**
 * Created by geely
 */
public class FanXianPromotionStrategy extends BaseStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销,返回的金额存放到慕课网用户的余额中");
        doSomething();
    }

    @Override
    protected void preDo() {
        System.out.println("返现促销,促销开始前doSomeThing");
    }

    @Override
    protected void afterDo() {
        System.out.println("返现促销,促销结束后doSomeThing");
    }
}
