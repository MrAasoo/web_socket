package com.aasoo.socket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@RestController
public class MessageController {

    @MessageMapping("/sendMessage") // This annotation maps messages sent to the "/app/sendMessage" endpoint
    @SendTo("/messages")
    // This annotation specifies that the response will be sent to the "/messages" broker destination
    @PostMapping("/sendMessage") // This annotation maps HTTP POST requests to the same endpoint
    public String sendMessage(String message) {
        // This method will handle incoming messages sent to the "/sendMessage" endpoint
        // You can process the message here and return a response
        // For now, we will just return the received message
        return LocalDate.now() + " "+ LocalTime.now() +" : " + message;
    }
}
