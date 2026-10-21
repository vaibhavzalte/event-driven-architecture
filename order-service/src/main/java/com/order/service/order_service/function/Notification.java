package com.order.service.order_service.function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class Notification {
    @Bean
    public Consumer<String> consumeAsk(){
        return (str)->{
            System.out.println("notifcation from notificaiton:=> "+ str);
        };
    }
}
