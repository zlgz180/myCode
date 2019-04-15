package com.code.design.enjoy.create.fatory.fatoryMethod;

import com.code.design.enjoy.entity.Bag;
import com.code.design.enjoy.entity.bag.BananaBag;

/**
 * 工厂方法模式
 */
public class BananaBagFactory implements BagFactory {
    public Bag getBag() {
        return new BananaBag();
    }
}
