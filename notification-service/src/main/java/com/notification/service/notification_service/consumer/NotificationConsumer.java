package com.notification.service.notification_service.consumer;

import com.notification.service.notification_service.event.OrderCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class NotificationConsumer {
    @Bean
    public Consumer<OrderCreatedEvent> orderEventReceiver() {
        return event -> {
            System.out.println("+++++++++++++++++++++++++++");
            System.out.println("Received OrderCreatedEvent: " + event);
            System.out.println("+++++++++++++++++++++++++++");
        };
    }
}
