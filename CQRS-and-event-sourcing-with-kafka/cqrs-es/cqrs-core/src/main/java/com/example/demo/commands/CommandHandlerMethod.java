package com.example.demo.commands;

@FunctionalInterface
public interface CommandHandlerMethod <T extends BaseCommand> {
    void handle(T command);
}
