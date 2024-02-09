package com.example.kafkaproducertwo.service;

import com.example.kafkaproducertwo.dto.Farewell;
import com.example.kafkaproducertwo.dto.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, Greeting> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Object> multiTypeKafkaTemplate;

    public void sendMessage(String topic, Greeting message) {
        kafkaTemplate.send(topic, message);
    }

    public void sendGreetingMessage(String topic, String name){
        multiTypeKafkaTemplate.send(topic, new Greeting("Greetings ", name));
    }

    public void sendFarewellMessage(String topic, String name){
        multiTypeKafkaTemplate.send(topic, new Farewell("Farewell "+name, 25));
    }

    public void sendSimpleMessage(String topic, String message) {
        multiTypeKafkaTemplate.send(topic, message);
    }


}
