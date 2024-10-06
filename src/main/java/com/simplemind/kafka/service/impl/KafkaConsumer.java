package com.simplemind.kafka.service.impl;

import com.simplemind.kafka.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer
{

    @KafkaListener(topics={"${demo-app.topic}"},groupId = "${demo-app.consumer-group}")
    public void consume(Student student)
    {
        log.info(String.format("consuming message :%s", student));
    }
}
