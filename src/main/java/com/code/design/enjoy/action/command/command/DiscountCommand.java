package com.code.design.enjoy.action.command.command;

import com.code.design.enjoy.action.command.Command;
import com.code.design.enjoy.action.command.handler.DiscountHandler;

public class DiscountCommand extends Command {

    private DiscountHandler handler = new DiscountHandler();

    @Override
    public String execute() {
        return handler.getDiscounts();
    }
}
