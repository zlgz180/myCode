package com.code.design.enjoy.structure.decorator;

import com.code.design.enjoy.entity.Bag;

public class BagDecorator implements Bag {
    private Bag bag; // 维持一个对抽象构件对象的引用

    public BagDecorator(Bag bag) // 注入一个抽象构件类型的对象
    {
        this.bag = bag;
    }

    @Override public void pack() {
        bag.pack();
    }
}
