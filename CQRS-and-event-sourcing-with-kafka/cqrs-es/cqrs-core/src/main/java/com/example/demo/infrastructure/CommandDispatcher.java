package com.example.demo.infrastructure;

import com.example.demo.commands.BaseCommand;
import com.example.demo.commands.CommandHandlerMethod;

public interface CommandDispatcher {
    <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);
    void send(BaseCommand command);
}
