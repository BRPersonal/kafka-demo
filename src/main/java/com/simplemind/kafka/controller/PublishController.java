package com.simplemind.kafka.controller;

import com.simplemind.kafka.service.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class PublishController
{
    private final MessageSender sender;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message)
    {
        sender.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }
}
