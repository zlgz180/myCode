package com.code.design.enjoy.create.fatory.abstractFactory;

import com.code.design.enjoy.entity.Bag;
import com.code.design.enjoy.entity.Fruit;
import com.code.design.enjoy.entity.bag.AppleBag;
import com.code.design.enjoy.entity.fruit.Apple;

/**
 * 水果工厂
 */
public class AppleFactory extends AbstractFactory {

    @Override
    public Fruit getFruit() {
        return new Apple();
    }

    @Override
    public Bag getBag() {
        return new AppleBag();
    }
}
