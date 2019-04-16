package com.code.design.enjoy.create.fatory.fatoryMethod;

import com.code.design.enjoy.entity.Fruit;
import com.code.design.enjoy.entity.fruit.Banana;

/**
 * 工厂方法模式
 */
public class BananaFactory implements FruitFactory {
    @Override public Fruit getFruit() {
        return new Banana();
    }
}
