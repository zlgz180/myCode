package com.code.design.enjoy.action.chain;

import com.code.design.enjoy.action.strategy.Discount;

/**
 * Created by Peter on 10/29 029.
 */
public abstract class MultyDiscount implements Discount {
    protected MultyDiscount nextMultyDiscount;

    public MultyDiscount(MultyDiscount nextMultyDiscount) {
        this.nextMultyDiscount = nextMultyDiscount;
    }

    @Override public int calculate(int money) {
        if (this.nextMultyDiscount != null) {
            return this.nextMultyDiscount.calculate(money);
        }
        return money;
    }

}
