package com.example.demo.infrastructure.consumers;

import com.example.demo.events.AccountClosedEvent;
import com.example.demo.events.AccountOpenedEvent;
import com.example.demo.events.FundsDepositedEvent;
import com.example.demo.events.FundsWithdrawnEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
    void consume(@Payload AccountOpenedEvent event, Acknowledgment ack);
    void consume(@Payload FundsDepositedEvent event, Acknowledgment ack);
    void consume(@Payload FundsWithdrawnEvent event, Acknowledgment ack);
    void consume(@Payload AccountClosedEvent event, Acknowledgment ack);
}
