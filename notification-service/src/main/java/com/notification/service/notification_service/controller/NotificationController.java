package com.notification.service.notification_service.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class NotificationController {

    @Bean
    Supplier<String> sayHello() {
        return () -> "hey hi";
    }

    @Bean
    Consumer<String> createNotification(){
        return msg ->
        System.out.println("MSG:::"+msg);
    }

    @Bean
    Function<String,String> processNotification(){
        return msg -> msg + ": SENT";
    }
}
