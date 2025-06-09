package com.aasoo.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public MessageController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping("/sendMessage") // This annotation maps HTTP POST requests to the same endpoint
    public String sendMessageViaPost(@RequestBody String message) {
        simpMessagingTemplate.convertAndSend("/topic/message", message); // This sends the message to the "/topic" destination
        return message;
    }

    @MessageMapping("/sendMessage") // This annotation maps messages sent to the "/app/sendMessage" endpoint
    @SendTo("/topic/message") // This annotation specifies that the response will be sent to the "/messages" broker destination
    public String sendMessageViaPush(String message) { // via websocket
        // This method will handle incoming messages sent to the "/sendMessage" endpoint
        // You can process the message here and return a response
        // For now, we will just return the received message
        return message;
    }
}
