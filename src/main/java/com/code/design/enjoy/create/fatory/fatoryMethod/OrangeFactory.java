package com.code.design.enjoy.create.fatory.fatoryMethod;

import com.code.design.enjoy.entity.Fruit;
import com.code.design.enjoy.entity.fruit.Orange;

/**
 * 工厂方法模式
 */
public class OrangeFactory implements FruitFactory {
    @Override public Fruit getFruit() {
        return new Orange("Peter", 80);
    }
}
