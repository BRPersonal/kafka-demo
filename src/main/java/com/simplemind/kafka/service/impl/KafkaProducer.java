package com.simplemind.kafka.service.impl;

import com.simplemind.kafka.service.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer implements MessageSender
{
    @Value("${demo-app.topic}")
    private String topic;

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void sendMessage(String msg)
    {
        log.debug("publishing to kafka topic:{}",topic);
        kafkaTemplate.send(topic,msg);
    }
}
