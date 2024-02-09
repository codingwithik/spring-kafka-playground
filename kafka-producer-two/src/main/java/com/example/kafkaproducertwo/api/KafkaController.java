package com.example.kafkaproducertwo.api;

import com.example.kafkaproducertwo.dto.Greeting;
import com.example.kafkaproducertwo.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/send")
    public ResponseEntity<String> sendGreeting(@RequestParam("name") String name) {
        messageProducer.sendMessage("test-1",  new Greeting("Hello", "World"));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/multi-send")
    public ResponseEntity<String> sendMultipleMessage(@RequestParam("name") String name) {
        messageProducer.sendMessage("greeting-1",  new Greeting("Hello ", name));
        messageProducer.sendGreetingMessage("greeting", name);
        messageProducer.sendSimpleMessage("simple-msg", name);
        messageProducer.sendFarewellMessage("farewell", name);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
