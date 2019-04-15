package com.code.design.enjoy.create.fatory.abstractFactory;

import com.code.design.enjoy.entity.Bag;
import com.code.design.enjoy.entity.Fruit;
import com.code.design.enjoy.entity.bag.OrangeBag;
import com.code.design.enjoy.entity.fruit.Orange;

/**
 * 水果工厂
 */
public class OrangeFactory extends AbstractFactory {

    @Override
    public Fruit getFruit() {
        return new Orange("Peter", 50);
    }

    @Override
    public Bag getBag() {
        return new OrangeBag();
    }
}
