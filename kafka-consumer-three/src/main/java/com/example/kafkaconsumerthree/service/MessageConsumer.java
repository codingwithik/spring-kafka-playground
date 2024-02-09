package com.example.kafkaconsumerthree.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "test-1", groupId = "test-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

//    @KafkaListener(
//            topics = "test-1, test-2",
//            groupId = "test-group-id")
//    void commonListenerForMultipleTopics(String message) {
//        LOG.info("MultipleTopicListener - {}", message);
//    }

}
