package com.simplemind.kafka.service;

import com.simplemind.kafka.model.Student;

public interface MessageSender
{
    public void sendMessage(Student student);
}
