package com.code.design.enjoy.create.fatory.fatoryMethod;

import com.code.design.enjoy.entity.Fruit;
import com.code.design.enjoy.entity.fruit.Apple;

/**
 * 工厂方法模式
 */
public class AppleFactory implements FruitFactory {
    public Fruit getFruit() {
        return new Apple();
    }
}
