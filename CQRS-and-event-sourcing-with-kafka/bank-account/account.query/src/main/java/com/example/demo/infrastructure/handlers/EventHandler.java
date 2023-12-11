package com.example.demo.infrastructure.handlers;

import com.example.demo.events.AccountClosedEvent;
import com.example.demo.events.AccountOpenedEvent;
import com.example.demo.events.FundsDepositedEvent;
import com.example.demo.events.FundsWithdrawnEvent;

public interface EventHandler {
    void on(AccountOpenedEvent event);
    void on(FundsDepositedEvent event);
    void on(FundsWithdrawnEvent event);
    void on(AccountClosedEvent event);
}
