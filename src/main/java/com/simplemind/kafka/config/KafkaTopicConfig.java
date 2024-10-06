package com.simplemind.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig
{
    @Value("${demo-app.topic}")
    private String topic;

    @Bean
    public NewTopic myTopic()
    {
        return TopicBuilder
                .name(topic)
                .build();

    }
}
