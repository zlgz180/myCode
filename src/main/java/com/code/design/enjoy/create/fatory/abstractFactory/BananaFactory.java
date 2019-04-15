package com.code.design.enjoy.create.fatory.abstractFactory;

import com.code.design.enjoy.entity.Bag;
import com.code.design.enjoy.entity.Fruit;
import com.code.design.enjoy.entity.bag.BananaBag;
import com.code.design.enjoy.entity.fruit.Banana;

/**
 * 水果工厂
 */
public class BananaFactory extends AbstractFactory {

    @Override
    public Fruit getFruit() {
        return new Banana();
    }

    @Override
    public Bag getBag() {
        return new BananaBag();
    }
}
