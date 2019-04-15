package com.code.design.enjoy.create.fatory.abstractFactory;

import com.code.design.enjoy.entity.Bag;
import com.code.design.enjoy.entity.Fruit;

/**
 * 抽象水果工厂
 */
public abstract class AbstractFactory {

    public abstract Fruit getFruit();

    public abstract Bag getBag();

}
