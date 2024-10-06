package com.simplemind.kafka.service.impl;

import com.simplemind.kafka.model.Student;
import com.simplemind.kafka.service.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;


@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer implements MessageSender
{
    @Value("${demo-app.topic}")
    private String topic;

    private final KafkaTemplate<String,Student> kafkaTemplate;

    @Override
    public void sendMessage(Student student)
    {
        log.debug("publishing to kafka topic:{}",topic);
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC,topic)
                .build();
        kafkaTemplate.send(message);

    }
}
