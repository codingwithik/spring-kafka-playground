package com.example.kafkaconsumertwo.service;

import com.example.kafkaconsumertwo.dto.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "test-2", groupId = "consumer-two-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topics = "test-1")
    void listener(String data) {
        LOG.info(data);
    }

    @KafkaListener(topics = "greeting")
    public void greetingListener(Greeting greeting) {
        LOG.info("Greeting topic {}",greeting);
    }


}
