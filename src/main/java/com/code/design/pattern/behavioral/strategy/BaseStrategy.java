package com.code.design.pattern.behavioral.strategy;

/**
 * @author tianwei
 * @since 2019-06-19 13:43
 */
public abstract class BaseStrategy implements PromotionStrategy {

    public void doSomething() {
        preDo();
        afterDo();
    }

    protected abstract void preDo();

    protected abstract void afterDo();
}
