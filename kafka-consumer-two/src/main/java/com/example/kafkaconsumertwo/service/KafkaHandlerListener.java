package com.example.kafkaconsumertwo.service;

import com.example.kafkaconsumertwo.dto.Farewell;
import com.example.kafkaconsumertwo.dto.Greeting;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
@KafkaListener(id = "multiGroup", topics = {"farewell", "greeting", "simple-msg"})
public class KafkaHandlerListener {

    @KafkaHandler
    public void handleGreeting(Greeting greeting) {
        System.out.println("Greeting received: " + greeting);
    }

    @KafkaHandler
    public void handleF(Farewell farewell) {
        System.out.println("Farewell received: " + farewell);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Unkown type received: " + object);
    }
}
