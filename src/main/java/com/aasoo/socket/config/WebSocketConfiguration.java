package com.aasoo.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Enable a simple in-memory message broker
        // This broker will handle messages sent to "/topic" and "/queue"
        // You can define as many topics and queues as needed
        registry.enableSimpleBroker("/topic", "/queue", "/messages");
        // Set the application destination prefix for messages
        // This prefix is used to route messages to the appropriate controllers
        // For example, messages sent to "/app/sendMessage" will be routed to a controller method
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Register the "/message" endpoint for WebSocket connections
        registry.addEndpoint("/message") // Define the endpoint WebSocket connections for clients
                .setAllowedOriginPatterns("*") // Allow all origins for CORS
                .withSockJS(); // Enable SockJS fallback options
    }

}
