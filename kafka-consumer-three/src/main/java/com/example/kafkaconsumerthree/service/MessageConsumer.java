package com.example.kafkaconsumerthree.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "test-2", groupId = "consumer-group-id")
    public void listen(String message) {
        LOG.info("Received message: {}", message);
    }


}
