package com.example.kafkaproducer.api;

import com.example.kafkaproducer.service.MessageProducer;
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
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        messageProducer.sendMessage("test-1", message);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessageToSecondTopic(@RequestParam("message") String message) {
        messageProducer.sendMessage("test-2", message);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
