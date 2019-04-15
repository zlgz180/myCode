package com.code.design.enjoy.action.command.command;

import com.code.design.enjoy.action.command.Command;
import com.code.design.enjoy.action.command.handler.NewerHandler;

public class NewerCommand extends Command {
    private NewerHandler handler = new NewerHandler();

    @Override
    public String execute() {
        return handler.getNewers();
    }
}
