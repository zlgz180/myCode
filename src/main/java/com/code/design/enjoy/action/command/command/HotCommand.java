package com.code.design.enjoy.action.command.command;

import com.code.design.enjoy.action.command.Command;
import com.code.design.enjoy.action.command.handler.HotHandler;

public class HotCommand extends Command {
    private HotHandler handler = new HotHandler();

    @Override
    public String execute() {
        return handler.getHots();
    }
}
