package com.example.demo.producers;

import com.example.demo.events.BaseEvent;

public interface EventProducer {
    void produce(String topic, BaseEvent event);
}
