package com.order.service.order_service.service;


import com.order.service.order_service.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final StreamBridge streamBridge;

    private final AtomicLong orderIdGenerator = new AtomicLong(100);

    public Long createOrder(String product,Integer quantity,String customerEmail) {
        Long orderId = orderIdGenerator.incrementAndGet();
        System.out.println("Order created: " + orderId);
        OrderCreatedEvent event =new OrderCreatedEvent(orderId,product,quantity,customerEmail);
        boolean sent =streamBridge.send("orderCreatedEvent-out-0",event);
        System.out.println("Event sent to Kafka: " + sent);
        return orderId;
    }
}
