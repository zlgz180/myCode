package com.code.design.enjoy.create.fatory.fatoryMethod;

import com.code.design.enjoy.entity.Bag;
import com.code.design.enjoy.entity.bag.AppleBag;

/**
 * 工厂方法模式
 */
public class AppleBagFactory implements BagFactory {
    @Override public Bag getBag() {
        return new AppleBag();
    }
}
