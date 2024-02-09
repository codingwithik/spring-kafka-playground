package com.example.kafkaconsumerone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "test-1", groupId = "test-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(
            topics = {"test-1, test-2"},
            groupId = "test-group-id")
    void commonListenerForMultipleTopics(String message) {
        LOG.info("MultipleTopicListener - {}", message);
    }

    // read all messages on start-up from partition 0 and 3
    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "test-1",
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0"),
                            @PartitionOffset(partition = "3", initialOffset = "0")}),
            containerFactory = "partitionsKafkaListenerContainerFactory")
    public void listenToPartition(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println(
                "Received Message: " + message + "from partition: " + partition);
    }

    // if we want to receive all the messages sent to a topic from the time of its creation on application startup
    // we can set the initial offset to zero:
    @KafkaListener(
            groupId = "reflectoring-group-3",
            topicPartitions = @TopicPartition(
                    topic = "reflectoring-1",
                    partitionOffsets = { @PartitionOffset(partition = "0", initialOffset = "0") }
            ))
    void listenToPartitionWithOffset(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message [{}] from partition-{} with offset-{}",
                message,
                partition,
                offset);
    }

    @KafkaListener(topics = "reflectoring-others")
    @SendTo("reflectoring-1")
    String listenAndReply(String message) {
        LOG.info("ListenAndReply [{}]", message);
        return "This is a reply sent after receiving message";
    }

    @KafkaListener(
            topics = "topicName",
            containerFactory = "filterKafkaListenerContainerFactory")
    public void listenWithFilter(String message) {
        System.out.println("Received Message in filtered listener: " + message);
    }

}
