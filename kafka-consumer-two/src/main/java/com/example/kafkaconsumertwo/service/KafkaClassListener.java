package com.example.kafkaconsumertwo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "class-level", topics = "reflectoring-3")
class KafkaClassListener {

    Logger LOG = LoggerFactory.getLogger(KafkaClassListener.class);

    @KafkaHandler
    void listen(String message) {
        LOG.info("KafkaHandler[String] {}", message);
    }

    @KafkaHandler(isDefault = true)
    void listenDefault(Object object) {
        LOG.info("KafkaHandler[Default] {}", object);
    }
}
